package com.fly.business.shortbook.service;

import com.fly.business.shortbook.dao.ShortBookChapterDao;
import com.fly.business.shortbook.dao.ShortBookContentDao;
import com.fly.business.shortbook.dao.ShortBookDao;
import com.fly.pojo.ShortBook;
import com.fly.pojo.ShortBookChapter;
import com.fly.pojo.ShortBookContent;
import com.fly.pojo.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author david
 * @date 12/08/18 13:14
 */
@Service
@Transactional
public class ShortBookServiceImpl implements ShortBookService {

    @Autowired
    private ShortBookDao sbd;
    @Autowired
    private ShortBookChapterDao sbcd;
    @Autowired
    private ShortBookContentDao sbcond;

    @Override
    public List<ShortBook> getBooks() {
        List<ShortBook> books = sbd.findAll();
        return books;
    }

    @Override
    public Map<String, List<ShortBookChapter>> getChapters(Integer bookId) {
        List<ShortBookChapter> chapters = sbcd.findByShortBookId(bookId);
        HashMap<String, List<ShortBookChapter>> res = new HashMap<>();
        for (ShortBookChapter chapter : chapters) {
            List<ShortBookChapter> subsets = res.get(chapter.getCategory());
            if (subsets == null) {
                subsets = new ArrayList<>();
            }
            subsets.add(chapter);
            res.put(chapter.getCategory(), subsets);
        }

        return res;
    }

    @Override
    public List<ShortBookContent> getContentByChapterId(Integer chapterId) {
        List<ShortBookContent> contents = sbcond.findByChapterId(chapterId);
        return contents;
    }

    @Override
    public List<ShortBookContent> getContentByBookId(Integer bookId) {
        List<ShortBookContent> contents = sbcond.findByShortBookId(bookId);
        return contents;
    }

    @Override
    public List search(String type, String keywords) {
        List res = new ArrayList();
        switch (type) {
            case "book":
                res = sbd.search("%" + keywords + "%");
                break;
            case "chapter":
                res = sbcd.search("%" + keywords + "%");
                break;
            case "content":
                res = sbcond.search("%" + keywords + "%");
                break;
        }
        return res;
    }

    @Override
    public Page<ShortBook> getSubjects(String scope, Integer p, Integer count) {
        List<ShortBook> books = new ArrayList<>();
        switch (scope) {
            case "ALL":
                Integer start = (p - 1) * count;
                books = sbd.findByPage(start, count);
                break;
            case "TOP5":
                break;
        }
        Page<ShortBook> page = new Page<>();
        Long l = sbd.count();
        page.setBody(books);
        page.setPage(p);
        page.setCount(count);
        page.setTotal(Integer.valueOf(l.toString()));
        return page;
    }

}
