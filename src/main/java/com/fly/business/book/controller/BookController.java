package com.fly.business.book.controller;

import com.fly.business.book.dao.BookDao;
import com.fly.business.book.service.BookService;
import com.fly.common.controller.BaseController;
import com.fly.pojo.Book;
import com.fly.pojo.BookShortComment;
import com.fly.pojo.vo.Page;
import com.fly.pojo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author david
 * @date 01/08/18 13:54
 */
@Controller
@RequestMapping("/book")
public class BookController extends BaseController {

    @Autowired
    private BookDao bd;
    @Autowired
    private BookService bs;

    @GetMapping("/size")
    @ResponseBody
    public Result getSize(Result result) {
        long l = bd.count();
        result.ok(l);
        return result;
    }

    @GetMapping("/subjects")
    @ResponseBody
    public Result findByPage(Result result,
                             @RequestParam(value = "p", defaultValue = "1") Integer p,
                             @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        p = this.validateIntNNWithDefaultValue(p, 1);
        Page<Book> page = bs.findByPage(p, count);
        result.ok(page);
        return result;
    }

    /**
     * 根据图书类型获取图书分页列表
     * @param result 返回参数
     * @param tagId 图书类型id
     * @param p 当前页码
     * @param count 每天请求条数
     * @return
     */
    @GetMapping("/subjects/{tag_id}")
    @ResponseBody
    public Result findByPageAndType(Result result,
                                    @PathVariable("tag_id") String tagId,
                                    @RequestParam(value = "p", defaultValue = "1") Integer p,
                                    @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        p = this.validateIntNNWithDefaultValue(p, 1);
        Page<Book> page = bs.findByPageAndType(tagId, p, count);
        return result.ok(page);
    }

    /**
     * 获取top250的图书分页列表
     * @param result
     * @param p
     * @param count
     * @return
     */
    @GetMapping("/subjects/top250")
    public Result findTop250(Result result,
                             @RequestParam(value = "p", defaultValue = "1") Integer p,
                             @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        Page<Book> page = bs.findTop250(p, count);
        result.ok(page);
        return result;
    }

    /**
     * 获取读书详情
     * @param result
     * @param book_id
     * @param count
     * @return
     */
    @GetMapping("/subject/{book_id}")
    @ResponseBody
    public Result findSubject(Result result, @PathVariable String book_id,
                              @RequestParam(value = "p", defaultValue = "1", required = false) Integer p,
                              @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        Book book = bs.findSubject(book_id, p, count);
        if (book == null) {
            result.error(404, "book not found!");
        } else {
            result.ok(book);
        }
        return result;
    }

    @GetMapping("/comment/{book_id}")
    @ResponseBody
    public Result findMoreComment(Result result,
                                  @PathVariable("book_id") String bookId,
                                  @RequestParam(value = "p", defaultValue = "1") Integer p,
                                  @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        p = this.validateIntNNWithDefaultValue(p, 1);
        List<BookShortComment> comments = bs.findCommentByPage(p, count, bookId);
        result.ok(comments);
        return result;
    }

}
