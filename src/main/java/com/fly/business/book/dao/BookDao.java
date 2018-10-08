package com.fly.business.book.dao;

import com.fly.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author david
 * @date 01/08/18 13:53
 */
@Repository
public interface BookDao extends JpaRepository<Book, String> {

    @Query(value = "SELECT * FROM douban_book ORDER BY stars DESC LIMIT :start, :count", nativeQuery = true)
    List<Book> findByPage(@Param("start") Integer start, @Param("count") Integer count);

    @Query(value = "SELECT b.* FROM douban_book b WHERE b.tag_id = :tag_id ORDER BY stars, publish_time DESC LIMIT :p, :count", nativeQuery = true)
    List<Book> findByPageAndType(@Param("tag_id") String tagId, @Param(("p")) Integer p, @Param("count") Integer count);

    Long countByTagId(@Param("tag_id") String tagId);

    @Query(nativeQuery = true, value = "SELECT b.* FROM fly.douban_book b WHERE b.id IN (:book_ids) ORDER BY publish_time DESC, stars DESC limit :start, :count")
    List<Book> findByIdsAndPage(@Param("book_ids") List<String> bookIds,
                                @Param("start") Integer start,
                                @Param("count") Integer count);

}
