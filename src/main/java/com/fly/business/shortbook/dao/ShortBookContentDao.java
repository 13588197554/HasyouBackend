package com.fly.business.shortbook.dao;

import com.fly.pojo.ShortBookContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @param
 * @author: 轻舞飞扬
 * Date: 2018-08-10
 */
@Repository
public interface ShortBookContentDao extends JpaRepository<ShortBookContent, Integer> {

    @Query("FROM ShortBookContent sbc WHERE sbc.chapterId = :chapterId ")
    List<ShortBookContent> findByChapterId(@Param("chapterId") Integer chapterId);

    @Query("FROM ShortBookContent sbc WHERE sbc.shortBookId = :bookId ")
    List<ShortBookContent> findByShortBookId(@Param("bookId") Integer bookId);

    @Query("FROM ShortBookContent sbc WHERE sbc.content LIKE :keywords")
    List search(@Param("keywords") String keywords);
}
