package com.fly.business.music.controller;

import com.fly.business.music.service.MusicService;
import com.fly.pojo.DoubanMusic;
import com.fly.pojo.vo.Page;
import com.fly.pojo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService ms;

    @GetMapping("/subjects/{tag_id}")
    @ResponseBody
    public Result findSubjects(Result result,
                               @PathVariable("tag_id") String tagId,
                               @RequestParam(value = "p", defaultValue = "1", required = false) Integer p,
                               @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        Page<DoubanMusic> page = ms.findByTagId(tagId, p, count);
        return result.ok(page);
    }

}
