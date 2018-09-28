package com.fly.business.v2.dao;

import com.fly.pojo.V2Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends JpaRepository<V2Post, String> {

    List<V2Post> findByIsSpider(Boolean isSpider);

    @Query(value = "select * from v2_post where is_spider = 0 limit 1", nativeQuery = true)
    V2Post findFirstBySpiderIsFalse();

    @Query(value = "select * from v2_post where is_spider = 0 and created > :created limit 1", nativeQuery = true)
    V2Post findFirstByCreated(@Param("created") long created);

    @Query(value = "select * from v2_post p where p.id = :id and p.type = :type", nativeQuery = true)
    V2Post findByIdAndType(@Param("id") String id, @Param("type") String type);

    @Query(value = "select p.node_id, count(1) from v2_post p where p.node_id in :ids group by node_id", nativeQuery = true)
    List<Object[]> findCountGroupByNode(@Param("ids") List<String> ids);

    List<V2Post> findByNodeId(String nodeId);

    @Query(value = "select p.* from v2_post p where p.node_id = :node_id limit :start, :count", nativeQuery = true)
    List<V2Post> findByNodeIdAndPage(@Param("node_id") String nodeId, @Param("start") Integer start, @Param("count") Integer count);

    Integer countByNodeId(String id);

    @Query("select p.id from V2Post p")
    List<String> findIds();
}
