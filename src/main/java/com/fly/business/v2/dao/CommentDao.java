package com.fly.business.v2.dao;

import com.fly.pojo.V2Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CommentDao extends JpaRepository<V2Comment, Integer> {

    @Query(value = "select c.post_id, count(1) from v2_comment c where c.post_id in :post_ids", nativeQuery = true)
    List<Object[]> countByPostIds(@Param("post_ids") List<String> postIds);

    Integer countByPostId(String postId);

    List<V2Comment> findByPostIdOrderByFloorNumber(String id);

    List<V2Comment> findByFloorNumberAndPostId(Integer integer, String id);

    @Query("select c.floorNumber from V2Comment c where c.postId = :id")
    Set<Integer> findFloorNumberByPostId(@Param("id") String id);
}
