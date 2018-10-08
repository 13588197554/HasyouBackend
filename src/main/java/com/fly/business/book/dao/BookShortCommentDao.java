package com.fly.business.book.dao;

import com.fly.pojo.BookShortComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author david
 * @date 20/08/18 19:50
 */
public interface BookShortCommentDao extends JpaRepository<BookShortComment, String> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM douban_book_short_comment WHERE book_id = :book_id " +
                    "ORDER BY votes DESC LIMIT :start, :count")
    List<BookShortComment> findByPage(@Param("book_id") String bookId,
                                      @Param("start") Integer start,
                                      @Param("count") Integer count);

    @Query(nativeQuery = true,
            value = "SELECT COUNT(1) FROM douban_book_short_comment WHERE book_id = :book_id " +
                    "ORDER BY votes DESC")
    Integer countByBookId(@Param("book_id") String bookId);
}
