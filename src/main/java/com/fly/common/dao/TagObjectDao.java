package com.fly.common.dao;

import com.fly.pojo.TagObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * @author david
 * @date 20/08/18 20:54
 */
public interface TagObjectDao extends JpaRepository<TagObject, Integer> {

    @Query(nativeQuery = true, value = "SELECT DISTINCT fk FROM fly.tag_object tob WHERE tag_id = :tag_id" +
            " ORDER BY fk DESC limit :start, :count")
    List<String> findIdsByTagIdAndPage(@Param("tag_id") String tagId,
                                       @Param("start") Integer start,
                                       @Param("count") Integer count);

    @Query(nativeQuery = true, value = "SELECT tag_id, COUNT(1) FROM fly.tag_object GROUP BY tag_id " +
            "HAVING tag_id IN (SELECT id FROM tag WHERE pid != '0' AND tag_type = 'DOUBAN_BOOK')")
    List<Map<String, Object>> countByIds(@Param("tag_ids") List<String> tagIds);

    Long countByTagId(String tagId);
}
