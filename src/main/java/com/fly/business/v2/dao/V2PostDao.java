package com.fly.business.v2.dao;

import com.fly.pojo.V2Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface V2PostDao extends JpaRepository<V2Post, String> {

    @Query(value = "select * from v2_post where node_id = :node_id order by created desc limit :start, :count", nativeQuery = true)
    List<V2Post> findByNodeId(@Param("node_id") String id, @Param("start") Integer start, @Param("count") Integer count);

    Integer countByNodeId(String NodeId);

    @Query(nativeQuery = true, value = "SELECT * FROM v2_post WHERE node_id = :node_id AND title LIKE :keywords ORDER BY created DESC LIMIT :start, :count")
    List<V2Post> search(@Param("node_id") String nodeId, @Param("keywords") String keywords, @Param("start") Integer start, @Param("count") Integer count);

    @Query(nativeQuery = true, value = "SELECT count(1) FROM v2_post WHERE title ORDER BY created DESC LIKE :s")
    Integer countByKeywords(@Param("s") String s);

    Integer countByType(String type);

    @Query(nativeQuery = true,
            value = "select * from v2_post WHERE type = :type order by last_modified desc limit :start, :count")
    List<V2Post> findByTypeAndPage(@Param("type") String type, @Param("start") Integer start, @Param("count") Integer count);
}
