package com.fly.common.controller;

import com.fly.business.v2.dao.CommentDao;
import com.fly.business.v2.dao.PostDao;
import com.fly.common.dao.TagDao;
import com.fly.pojo.Book;
import com.fly.pojo.V2Post;
import com.fly.pojo.vo.Result;
import com.fly.util.SQLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author david
 * @date 23/08/18 16:06
 */
@RestController
public class TestController {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private TagDao td;
    @Autowired
    private SQLUtil<Book> su;
    @Autowired
    private PostDao pd;
    @Autowired
    private CommentDao cd;

    @GetMapping("/test")
    public Result result(Result result) {
        return result.ok(1);
    }

    @GetMapping("/test2")
    public Result result2(Result result) {
        V2Post post = new V2Post();
        return result.ok("hello world");
    }

    @GetMapping("/t")
    public Result v(Result result) {
        return result;
    }

    @PostMapping("/test3")
    public Result result3(Result result) {
        return result;
    }

}
