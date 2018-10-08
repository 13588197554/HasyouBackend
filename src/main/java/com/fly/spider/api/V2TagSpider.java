package com.fly.spider.api;

import com.alibaba.fastjson.JSON;
import com.fly.business.v2.dao.MemberDao;
import com.fly.business.v2.dao.NodeDao;
import com.fly.business.v2.dao.PostDao;
import com.fly.enums.TypeEnum;
import com.fly.pojo.V2Member;
import com.fly.pojo.V2Node;
import com.fly.pojo.V2Post;
import com.fly.spider.BaseSpider;
import com.fly.util.LogUtil;
import com.fly.util.TimeUtil;
import com.fly.util.Util;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static com.fly.config.Constants.V2_HOT_URL;
import static com.fly.config.Constants.V2_LATEST_URL;

@Component
public class V2TagSpider extends BaseSpider {

    @Autowired
    private PostDao pd;
    @Autowired
    private NodeDao nd;
    @Autowired
    private MemberDao md;

    @Value("${MEMBER_URL_PREFIX}")
    private String MEMBER_URL_PREFIX;

    /**
     * 1 per hour
     * @throws IOException
     */
    @Async
    @Scheduled(fixedRate = 3600 * 1000, initialDelay = 1800 * 1000)
    public void hotStart() throws InterruptedException {
        savePosts(V2_HOT_URL, TypeEnum.HOT.getName());
    }

    /**
     * per 1 hour and delay for 30 minutes for init
     * @throws IOException
     */
    @Async
    @Scheduled(fixedDelay = 3600 * 1000)
    public void latestStart() throws IOException {
        try {
            savePosts(V2_LATEST_URL, TypeEnum.LATEST.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void savePosts(String url, String type) throws InterruptedException {
        Document document = null;
        try {
            document = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get();
            Element body = document.select("body").get(0);
            String json = body.text();
            List<V2Post> posts = JSON.parseArray(json, V2Post.class);
            for (V2Post post : posts) {
                V2Member member = post.getMember();
                V2Node node = post.getNode();
                post.setNodeId(node.getId());
                post.setMemberId(member.getId());
                post.setType(type);
                post.setCreateTime(TimeUtil.getTime(post.getCreated() * 1000L));
                post.setUpdateTime(TimeUtil.getTime(post.getLastModified() * 1000L));
                post.setSpider(false);
                pd.save(post);
                nd.save(node);
                md.save(member);
            }
        } catch (HttpStatusException hse) {
            LogUtil.info(V2TagSpider.class, "savePosts", hse);
            if (400 == hse.getStatusCode()) {
                Util.getRandomSleep(15 * 60 * 1000); // 15 minutes
            } else if (403 == hse.getStatusCode()) {
                Util.getRandomSleep(3 * 3600 * 1000); // 3 hours
            }
            return;
        } catch (Exception e) {
            LogUtil.info(V2TagSpider.class, "savePosts", e);
            e.printStackTrace();
            return;
        }
    }

}
