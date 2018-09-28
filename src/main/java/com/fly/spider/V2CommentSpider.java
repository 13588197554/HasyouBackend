package com.fly.spider;

import com.fly.business.v2.dao.CommentDao;
import com.fly.business.v2.dao.MemberDao;
import com.fly.business.v2.dao.PostDao;
import com.fly.enums.StatusEnum;
import com.fly.pojo.V2Comment;
import com.fly.pojo.V2Post;
import com.fly.util.RedisUtil;
import com.fly.util.Util;
import org.jsoup.HttpStatusException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Set;

@Component
@Scope("prototype")
public class V2CommentSpider extends BaseSpider {

    private static final Logger logger = LoggerFactory.getLogger(V2CommentSpider.class);

    @Autowired
    private PostDao pd;
    @Autowired
    private MemberDao md;
    @Autowired
    private CommentDao cd;

    @Value("${MEMBER_URL_PREFIX}")
    private String MEMBER_URL_PREFIX;
    @Value("${V2COMMENT_URL}")
    private String V2COMMENT_URL;

    @Autowired
    private RedisUtil jedis;

    private static String V2_MEMBER = "V2_MEMBER";

    /**
     * per 12 hours after the priorer finished
     * @throws IOException
     * @throws InterruptedException
     */
    @Async
    public void spiderComment(V2Post post) {
        String updateTime = post.getUpdateTime();
        Long lastTouched = Util.getTimestamp(updateTime);
        if (Util.getCurrentTimestamp() - lastTouched <= 3600 * 1000) {
            // 活跃时间为一个小时前，则更新
            return;
        }
        int p = 1;
        if (post.getCommentCount() != null) {
            p = post.getCommentCount() / 100;
            p = p == 0 ? 1 : p;
        }
        int bound = p;
        for (; p <= bound; p++) {
            long start = Util.getCurrentTimestamp();
            try {
                // server for 118.25.37.27
                Document document = null;
                try {
                    String url = V2COMMENT_URL + post.getId() + "?p=" + p;
                    document = this.getQuickConn(url);
                } catch (SocketTimeoutException ste) {
                    ste.printStackTrace();
                    continue;
                } catch (HttpStatusException hse) {
                    if (400 == hse.getStatusCode()) {
                        hse.printStackTrace();
                        System.out.println("spider comment waiting for 15 minutes!");
                        Util.getRandomSleep(15 * 60);
                        continue;
                    }
                    if (403 == hse.getStatusCode()) {
                        System.out.println("come across 403 for v2! spider comment sleep for 5 hours.......");
                        Util.getRandomSleep(5 * 3600);  // for 5 hours
                        continue;
                    }
                } catch (IOException ioe) {
                    post.setSpider(true);
                    pd.save(post);
                    ioe.printStackTrace();
                    continue;
                }
                System.out.println("--processing url: " + post.getUrl() + " --process time: " + Util.getCurrentFormatTime());
                Elements divs = null;
                try {
                    // total page
                    String pageText = document.select("div.cell span.gray").text();
                    String[] strings = pageText.split(" ");
                    Integer size = Integer.valueOf(strings[0]);
                    bound = size / 100 + 1;

                    // comment list
                    divs = document.select("div[id^=r_]");
                    post.setCommentCount(size);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    post.setSpider(true);
                    pd.save(post);
                    continue;
                }

                Set<Integer> floorNumbers = cd.findFloorNumberByPostId(post.getId());
                List<String> usernames = jedis.lrange(V2_MEMBER, 0, -1);
                for (Element div : divs) {
                    String idStr = div.attr("id");
                    String id = idStr.substring(2, idStr.length() - 1);
                    Elements trs = div.select("tr");
                    for (Element tr : trs) {
                        Elements tds = tr.select("td");
                        Element infoTdTag = tds.get(2);
                        String username = infoTdTag.select("strong>a").text().trim();
                        if (!usernames.contains(username)) {
                            jedis.rpush(V2_MEMBER, username);
                        }

                        String extra = infoTdTag.select("span.ago").text().trim();
                        String content = infoTdTag.select("div.reply_content").text();
                        String no = infoTdTag.select("span.no").text().trim();
                        Integer floorNumber = Integer.valueOf(no);

                        if (floorNumbers.contains(floorNumber)) {
                            continue;
                        }

                        V2Comment comment = new V2Comment();
                        this.matchInfo(extra, comment);
                        comment.setId(Integer.valueOf(id));
                        comment.setContent(content);
                        comment.setPostId(post.getId());
                        comment.setAuthor(username);
                        comment.setFloorNumber(Integer.valueOf(no));
                        comment.setStatus(StatusEnum.ACTIVE.getName());
                        cd.save(comment);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("normally sleeping!");
                Util.getRandomSleep(10, 15);
                long end = Util.getCurrentTimestamp();
                System.out.println(" -- processed time : " + (end - start) / 1000);
            }
        }
        post.setUpdateTime(Util.getCurrentFormatTime());
        pd.save(post);
    }

    private V2Comment matchInfo(String info, V2Comment comment) {
        info = info.replace(" ", "");
        String createTime = "";
        String device = "Web";
        if (info.contains("天前")) {
            String[] strings1 = info.split("天前");
            String s = strings1[0];
            Integer day = Integer.valueOf(s);
            createTime = Util.getTime(Util.getCurrentTimestamp() - (day * 24 * 3600 * 1000));
        } else if (info.contains("小时")) {
            String[] strs = info.split("小时");
            String h = strs[0];
            Integer hour = Integer.valueOf(h);
            Integer minute = 0;

            if (info.contains("分钟")) {
                String remain = strs[1];
                String[] strs2 = remain.split("分钟");
                String m = strs2[0];
                minute = Integer.valueOf(m);
            }
            createTime = Util.getTime(Util.getCurrentTimestamp() - (hour * 3600 * 1000) - (minute * 60 * 1000));
        } else if (info.contains("分钟")) {
            String[] mStr = info.split("分钟");
            String m = mStr[0];
            Integer minute = Integer.valueOf(m);
            createTime = Util.getTime(Util.getCurrentTimestamp() - (minute) * 60 * 1000);
        }

        if (info.contains("via")) {
            String[] vias = info.split("via");
            device = vias[1];
        }
        comment.setCreateTime(createTime);
        comment.setDevice(device);
        return comment;
    }

}
