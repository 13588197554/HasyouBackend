package com.fly.business.v2.service;

import com.fly.pojo.V2Member;
import com.fly.pojo.V2Post;
import com.fly.pojo.vo.Page;

public interface V2PostService {

    Page<V2Post> findByPage(String nodeName, Integer start, Integer count);

    V2Post findPost(String id);

    Page<V2Post> search(String nodeId, String keywords, Integer p, Integer count);

    Page<V2Post> findByTypeAndPage(String type, Integer p, Integer count);

    V2Member findMemberById(String memberId);
}
