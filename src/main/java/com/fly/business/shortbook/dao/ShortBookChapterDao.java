package com.fly.business.shortbook.dao;

import com.fly.pojo.ShortBookChapter;
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
public interface ShortBookChapterDao extends JpaRepository<ShortBookChapter, Integer> {

    @Query("FROM ShortBookChapter sb WHERE sb.shortBookId = :bookId")
    List<ShortBookChapter> findByShortBookId(@Param("bookId") Integer bookId);

    @Query("FROM ShortBookChapter sb WHERE sb.name = :keywords")
    List search(@Param("keywords") String keywords);
}
