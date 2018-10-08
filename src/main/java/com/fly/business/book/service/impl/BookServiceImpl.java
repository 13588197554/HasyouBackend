package com.fly.business.book.service.impl;

import com.alibaba.fastjson.JSON;
import com.fly.business.book.dao.BookDao;
import com.fly.business.book.dao.BookShortCommentDao;
import com.fly.business.book.service.BookService;
import com.fly.common.dao.TagObjectDao;
import com.fly.pojo.Book;
import com.fly.pojo.BookShortComment;
import com.fly.pojo.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author david
 * @date 20/08/18 19:08
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bd;
    @Autowired
    private BookShortCommentDao bscd;
    @Autowired
    private TagObjectDao tod;

    @Override
    public Page<Book> findByPage(Integer p, Integer count) {
        Integer start = (p - 1) * count;
        List<Book> books = bd.findByPage(start, count);

        this.handleBookInfo(books);

        Page<Book> page = new Page<>();
        Long total = bd.count();
        page.setTotal(Integer.valueOf(total.toString()));
        page.setPage(p);
        page.setCount(count);
        page.setBody(books);
        return page;
    }

    @Override
    public Book findSubject(String id, Integer p, Integer count) {
        Optional<Book> op = bd.findById(id);
        if (!op.isPresent()) {
            return null;
        }
        Book book = op.get();
        this.handleBookInfo(book);

        // comment
//        Integer start = (p - 1) * count;
//        List<BookShortComment> comments = bscd.findByPage(id, start, count);
//        Integer total = bscd.countByBookId(id);
//        book.setComments(comments);
//        book.setCommentsCount(total);
        return book;
    }

    @Override
    public Page<Book> findTop250(Integer p, Integer count) {
        Integer start = (p - 1) * count;
        start = (p - 1) * count >= 250 ? 250 : start;
        List<Book> books = bd.findByPage(p, count);
        Page<Book> page = new Page<>();

        this.handleBookInfo(books);

        page.setPage(p);
        page.setTotal(250);
        page.setCount(count);
        page.setBody(books);
        return page;
    }

    @Override
    public Page<BookShortComment> findCommentByPage(Integer p, Integer count, String bookId) {
        Integer start = (p - 1) * count;
        List<BookShortComment> comments = bscd.findByPage(bookId, start, count);
        Page<BookShortComment> page = new Page<>();
        page.setBody(comments);
        page.setPage(p);
        Integer total = bscd.countByBookId(bookId);
        page.setTotal(total);
        return page;
    }

    @Override
    public Page<Book> findByPageAndType(String tagId, Integer p, Integer count) {
        Integer start = (p - 1) * count;
        List<String> bookIds = tod.findIdsByTagIdAndPage(tagId, start, count);
//        Long total = tod.countByTagId(tagId);
        List<Book> books = bd.findAllById(bookIds);

        this.handleBookInfo(books);
        Page<Book> page = new Page<>();
        page.setTotal(0);
        page.setCount(count);
        page.setPage(p);
        page.setBody(books);
        return page;
    }

    private void handleBookInfo(List<Book> books) {
        for (Book book : books) {
            this.handleBookInfo(book);
        }
    }

    private void handleBookInfo(Book book) {
        String authorJson = book.getAuthor();
        String translatorJson = book.getTranslator();
        List<String> authors = JSON.parseArray(authorJson, String.class);
        List<String> translators = JSON.parseArray(translatorJson, String.class);
        book.setAuthors(authors);
        book.setTranslators(translators);
    }

}
