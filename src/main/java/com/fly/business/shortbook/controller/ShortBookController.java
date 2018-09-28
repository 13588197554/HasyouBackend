package com.fly.business.shortbook.controller;

import com.fly.business.shortbook.service.ShortBookService;
import com.fly.common.dao.TagDao;
import com.fly.common.dao.TagObjectDao;
import com.fly.pojo.ShortBook;
import com.fly.pojo.ShortBookChapter;
import com.fly.pojo.ShortBookContent;
import com.fly.pojo.vo.Page;
import com.fly.pojo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author david
 * @date 12/08/18 13:10
 */
@Controller
@RequestMapping("/shortbook")
public class ShortBookController {

    @Autowired
    private ShortBookService sbs;
    @Autowired
    private TagDao td;
    @Autowired
    private TagObjectDao tod;

    @GetMapping("/books")
    @ResponseBody
    public Result getBooks(Result result) {
        List<ShortBook> books = sbs.getBooks();
        result.ok(books);
        return result;
    }

    @GetMapping("/subjects")
    @ResponseBody
    public Result list(Result result,
                       @RequestParam("scope") String scope,
                       @RequestParam("p") Integer p,
                       @RequestParam("count") Integer count) {
        Page<ShortBook> page = sbs.getSubjects(scope, p, count);
        return result.ok(page);
    }

    @GetMapping("/chapters/{book_id}")
    @ResponseBody
    public Result getChapters(Result result, @PathVariable("book_id") Integer bookId) {
        Map<String, List<ShortBookChapter>> chapters = sbs.getChapters(bookId);
        result.ok(chapters);
        return result;
    }

    /**
     * 根据章节id获取内容
     * @param result
     * @param chapterId
     * @return
     */
    @GetMapping("/cc/{chapter_id}")
    @ResponseBody
    public Result getContentsByChapterId(Result result,
                                         @PathVariable("chapter_id") Integer chapterId) {
        List<ShortBookContent> contents = sbs.getContentByChapterId(chapterId);
        result.ok(contents);
        return result;
    }

    /**
     * 根据图书id获取内容
     * @param result
     * @param bookId
     * @return
     */
    @GetMapping("/cb/{book_id}")
    @ResponseBody
    public Result getContentByBookId(Result result, @PathVariable("book_id") Integer bookId) {
        List<ShortBookContent> contents = sbs.getContentByBookId(bookId);
        result.ok(contents);
        return result;
   }

   @GetMapping("/{type}/search/{keywords}")
   @ResponseBody
   public Result search(Result result,
                        @PathVariable("type") String type,
                        @PathVariable("keywords") String keywords,
                        @RequestParam("keywords1") String keywords1) {
        System.out.println(keywords1);
        List books = sbs.search(type, keywords);
        result.ok(books);
        return result;
   }

   @GetMapping("/type")
    @ResponseBody
    public Result types(Result result,
                        @RequestParam(value = "type", defaultValue = "DOUBAN_BOOK", required = false) String type) {

        return result;
   }

}
