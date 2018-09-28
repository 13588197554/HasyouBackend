package com.fly.business.shortbook.dao;

import com.fly.pojo.ShortBook;
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
public interface ShortBookDao extends JpaRepository<ShortBook, Integer> {

    @Query("FROM ShortBook sb WHERE sb.name LIKE :keywords")
    List search(@Param("keywords") String keywords);

    @Query(nativeQuery = true, value = "select * from short_book limit :start, :count")
    List<ShortBook> findByPage(@Param("start") Integer start, @Param("count") Integer count);
}
