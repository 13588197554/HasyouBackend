package com.fly.business.book.service;

import com.fly.pojo.Book;
import com.fly.pojo.BookShortComment;
import com.fly.pojo.vo.Page;

import java.util.List;

/**
 * @author david
 * @date 20/08/18 19:08
 */
public interface BookService {
    Page<Book> findByPage(Integer p, Integer count);

    Book findSubject(String id, Integer p, Integer count);

    List<BookShortComment> findCommentByPage(Integer p, Integer count, String bookId);

    Page<Book> findTop250(Integer p, Integer count);

    Page<Book> findByPageAndType(String tagId, Integer p, Integer count);
}
