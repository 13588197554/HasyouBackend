package com.fly.business.v2.service.impl;

import com.fly.business.v2.dao.CommentDao;
import com.fly.business.v2.dao.MemberDao;
import com.fly.business.v2.dao.V2NodeDao;
import com.fly.business.v2.dao.V2PostDao;
import com.fly.business.v2.service.V2PostService;
import com.fly.exception.ModelNotFoundException;
import com.fly.pojo.V2Comment;
import com.fly.pojo.V2Member;
import com.fly.pojo.V2Node;
import com.fly.pojo.V2Post;
import com.fly.pojo.vo.Page;
import com.fly.spider.V2CommentSpider;
import com.fly.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class V2PostServiceImpl implements V2PostService {

    @Autowired
    private V2PostDao pd;
    @Autowired
    private V2NodeDao nd;
    @Autowired
    private CommentDao cd;
    @Autowired
    private MemberDao md;

    @Autowired
    private V2CommentSpider cs;

    @Override
    public Page<V2Post> findByPage(String nodeName, Integer p, Integer count) {
        List<V2Node> nodes = nd.findByName(nodeName);
        if (nodes.size() >= 2) {
            throw new RuntimeException("not unique result!");
        }

        Integer start = (p - 1) * count;
        V2Node node = nodes.get(0);
        List<V2Post> posts = pd.findByNodeId(node.getId(), start, count);
        posts.forEach( (V2Post e) -> {
            e.setNode(node);
            Integer created = e.getCreated();
//            Integer commentCount = cd.countByPostId(node.getId());
            Integer active = e.getLastModified();
            e.setActiveTime(Util.getTime(Long.valueOf(active) * 1000));
            e.setCreateTime(Util.getTime(Long.valueOf(created) * 1000));
        });

        // append member
        this.appendMember(posts);

        Page<V2Post> page = new Page<>();
        // get total
        Long total = pd.countByNodeId(node.getId());
        page.setTotal(total);
        page.setBody(posts);
        page.setCount(count);
        page.setPage(p);
        Map<Object, Object> extra = new HashMap<>();
        extra.put("node", node);
        page.setExtra(extra);
        return page;
    }

    @Override
    public V2Post findPost(String id) {
        Optional<V2Post> op = pd.findById(id);

        if (!op.isPresent()) {
            throw new ModelNotFoundException("V2Post");
        }

        V2Post post = op.get();
        Integer created = post.getCreated();
        Integer active = post.getLastModified();
        post.setCreateTime(Util.getTime(Long.valueOf(created) * 1000));
        post.setActiveTime(Util.getTime(Long.valueOf(active) * 1000));
        Optional<V2Member> memberOp = md.findById(post.getMemberId());
        if (memberOp.isPresent()) {
            post.setMember(memberOp.get());
        }

        List<V2Comment> comments = cd.findByPostIdOrderByFloorNumber(post.getId());

        if (comments.size() != 0) {
            Set<String> authors = new HashSet<>();
            for (V2Comment comment : comments) {
                authors.add(comment.getAuthor());
            }

            List<V2Member> members = md.findByUsernames(authors);
            Map<String, V2Member> memberMap = Util.getReferFromList("username", members);

            for (V2Comment comment : comments) {
                V2Member member = memberMap.get(comment.getAuthor());
                comment.setMember(member);
            }
        }

        Optional<V2Node> nodeOp = nd.findById(post.getNodeId());
        if (nodeOp.isPresent()) {
            post.setNode(nodeOp.get());
        }

        post.setComments(comments);
        cs.spiderComment(post);
        return post;

    }

    @Override
    public Page<V2Post> search(String nodeId, String keywords, Integer p, Integer count) {
        Integer start = (p - 1) * count;
        Optional<V2Node> op = nd.findById(nodeId);
        if (!op.isPresent()) {
            throw new ModelNotFoundException("node");
        }

        V2Node node = op.get();
        List<V2Post> posts = pd.search(nodeId, "%" + keywords + "%", start, count);
        posts.forEach(e -> {
            e.setNode(node);
            Integer commentCount = cd.countByPostId(e.getId());
            e.setCommentCount(commentCount);
        });

        Long total = pd.countByKeywords("%" + keywords + "%");
        Page<V2Post> page = new Page<>();
        page.setTotal(total);
        page.setPage(p);
        page.setCount(count);
        return page;
    }

    @Override
    public Page<V2Post> findByTypeAndPage(String type, Integer p, Integer count) {
        Integer start = (p - 1) * count;
        List<V2Post> posts = pd.findByTypeAndPage(type, start, count);

        Set<String> nodeIds = new HashSet<>();
        List<String> postIds = new ArrayList<>();
        Set<String> memberIds = new HashSet<>();

        for (V2Post post : posts) {
            memberIds.add(post.getMemberId());
            nodeIds.add(post.getNodeId());
            postIds.add(post.getId());
        }

        Map<String, V2Post> postMap = Util.getReferFromList("id", posts);

        List<V2Member> members = md.findByIds(memberIds);
        List<V2Node> nodes = nd.findByIds(nodeIds);

        Map<String, V2Member> memberRefer = Util.getReferFromList("id", members);
        Map<String, V2Node> nodeRefer = Util.getReferFromList("id", nodes);

        for (V2Post post : posts) {
            post.setMember(memberRefer.get(post.getMemberId()));
            post.setNode(nodeRefer.get(post.getNodeId()));
            Integer created = post.getCreated();
            post.setCreateTime(Util.getTime(Long.valueOf(created) * 1000));
        }

        Long total = pd.countByType(type);
        Page<V2Post> page = new Page<>();
        page.setBody(posts);
        page.setPage(p);
        page.setCount(count);
        page.setTotal(total);
        return page;
    }

    @Override
    public V2Member findMemberById(String memberId) {
        Optional<V2Member> op = md.findById(memberId);
        if (!op.isPresent()) {
            throw new ModelNotFoundException("member");
        }
        return op.get();
    }

    private List<V2Post> appendMember(List<V2Post> posts) {
        Set<String> memberIds = new HashSet<>();
        for (V2Post post : posts) {
            memberIds.add(post.getMemberId());
        }
        List<V2Member> members = md.findByIds(memberIds);
        Map<String, V2Member> memberRefer = Util.getReferFromList("id", members);

        for (V2Post post : posts) {
            V2Member member = memberRefer.get(post.getMemberId());
            post.setMember(member);
        }
        return posts;
    }

}
