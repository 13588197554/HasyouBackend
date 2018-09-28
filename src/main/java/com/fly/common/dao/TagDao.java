package com.fly.common.dao;

import com.fly.pojo.FlyTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author david
 * @date 20/08/18 20:53
 */
public interface TagDao extends JpaRepository<FlyTag, String> {

    @Query("SELECT t FROM FlyTag t WHERE t.tagName = :tag_name AND t.tagType = :tag_type")
    List<FlyTag> findByNameAndTagType(@Param("tag_name") String tagName, @Param("tag_type") String tagType);

    @Query("SELECT t FROM FlyTag t WHERE t.tagType = :tag_type")
    List<FlyTag> findByTagType(@Param("tag_type") String tagType);

}
