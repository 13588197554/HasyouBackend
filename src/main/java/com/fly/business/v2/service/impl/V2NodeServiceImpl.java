package com.fly.business.v2.service.impl;

import com.fly.business.v2.dao.CommentDao;
import com.fly.business.v2.dao.MemberDao;
import com.fly.business.v2.dao.NodeDao;
import com.fly.business.v2.dao.PostDao;
import com.fly.business.v2.service.V2NodeService;
import com.fly.pojo.V2Member;
import com.fly.pojo.V2Node;
import com.fly.pojo.V2Post;
import com.fly.pojo.vo.Page;
import com.fly.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * @author david
 * @date 03/08/18 19:35
 */
@Service
@Transactional
public class V2NodeServiceImpl implements V2NodeService {

    @Autowired
    private NodeDao nd;
    @Autowired
    private PostDao pd;
    @Autowired
    private CommentDao cd;
    @Autowired
    private MemberDao md;

    @Override
    public Page<List<V2Node>> findByPage(Integer p, Integer count, Page page) {
        Integer start = (p - 1) * count;
        List<V2Node> nodes = nd.findByPage(start, count);
        page.setCount(nodes.size());
        page.setPage(p);
        Long total = nd.count();
        page.setTotal(Integer.valueOf(total.toString()));
        if (nodes.size() == 0) {
            return page;
        }

        ArrayList<String> ids = new ArrayList<>();
        HashMap<String, V2Node> map = new HashMap<>();
        for (V2Node node : nodes) {
            ids.add(node.getId());
            map.put(node.getId(), node);
        }

        List<Object[]> postCounts = pd.findCountGroupByNode(ids);
        for (Object[] oArray : postCounts){
            String nodeId = (String) oArray[0];
            String countStr = oArray[1].toString();
            V2Node node = map.get(nodeId);
            node.setPostCount(Integer.valueOf(countStr));
        }

        page.setBody(nodes);
        return page;
    }

    @Override
    public V2Node findDetail(String id, Integer p, Integer count) {
        Optional<V2Node> op = nd.findById(id);
        if (!op.isPresent()) {
            throw new RuntimeException("node not found!");
        }

        V2Node node = op.get();
        Integer start = (p - 1) * count;
        List<V2Post> posts = pd.findByNodeIdAndPage(id, start, count);
        Map<String, V2Post> postMap = Util.getReferFromList("id", posts);
        List<String> postIds = Util.getKeysFromMap(postMap);
        List<Object[]> commentCount = cd.countByPostIds(postIds);
        // comment
        for (Object[] oArr : commentCount) {
            String postId = (String) oArr[0];
            if (postId == null) {
                break;
            }
            String cc = oArr[1].toString();
            V2Post post = postMap.get(postId);
            post.setCommentCount(Integer.valueOf(cc));
        }

        // member
        for (V2Post post : posts) {
            Optional<V2Member> optional = md.findById(post.getMemberId());
            if (!optional.isPresent()) {
                throw new RuntimeException("member not found!");
            }
            V2Member member = optional.get();
            post.setMember(member);
        }

        node.setPosts(posts);
        node.setPostCount(posts.size());
        return node;
    }

    @Override
    public List<V2Node> searchNode(String keywords) {
        List<V2Node> nodes = nd.search("%" + keywords + "%");
        return nodes;
    }

    @Override
    public List<V2Node> findAll() {
        List<V2Node> nodes = nd.findAll();

//        for (V2Node node : nodes) {
//            Integer postCount = pd.countByNodeId(node.getId());
//            node.setPostCount(postCount);
//        }

        return nodes;
    }
}
