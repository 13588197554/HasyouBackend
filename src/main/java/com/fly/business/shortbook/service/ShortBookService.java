package com.fly.business.shortbook.service;

import com.fly.pojo.ShortBook;
import com.fly.pojo.ShortBookChapter;
import com.fly.pojo.ShortBookContent;
import com.fly.pojo.vo.Page;

import java.util.List;
import java.util.Map;

/**
 * @author david
 * @date 12/08/18 13:12
 */
public interface ShortBookService {

    List<ShortBook> getBooks();

    Map<String, List<ShortBookChapter>> getChapters(Integer bookId);

    List<ShortBookContent> getContentByChapterId(Integer chapterId);

    List<ShortBookContent> getContentByBookId(Integer bookId);

    List search(String type, String keywords);

    Page<ShortBook> getSubjects(String scope, Integer p, Integer count);
}
