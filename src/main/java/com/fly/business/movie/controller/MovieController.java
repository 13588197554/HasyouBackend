package com.fly.business.movie.controller;

import com.fly.business.movie.serevice.MovieService;
import com.fly.pojo.DoubanMovie;
import com.fly.pojo.FlyTag;
import com.fly.pojo.vo.Page;
import com.fly.pojo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movie")
@Controller
public class MovieController {

    @Autowired
    private MovieService ms;

    @GetMapping("/size")
    @ResponseBody
    public Result size(Result result) {
        Long count = ms.size();
        result.ok(count);
        return result;
    }

    @GetMapping("/subjects")
    @ResponseBody
    public Result findByPage(Result result,
                         @RequestParam("type") String type,
                         @RequestParam(value = "p", defaultValue = "1") Integer p,
                         @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        Page<DoubanMovie> page = ms.findByPage(type, p, count);
        return result.ok(page);
    }

    @GetMapping("/tags/{type}")
    @ResponseBody
    public Result findTags(Result result,
                           @PathVariable("type") String type) {
        List<FlyTag> tags = ms.findTags(type);
        return result.ok(tags);

    }

    @GetMapping("/subjects/{tag_id}")
    @ResponseBody
    public Result findByTagId(Result result,
                              @PathVariable("tag_id") String tagId,
                              @RequestParam(value = "p", defaultValue = "1",required = false) Integer p,
                              @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        Page<DoubanMovie> page = ms.findByTagId(tagId, p, count);
        return result.ok(page);
    }

}
