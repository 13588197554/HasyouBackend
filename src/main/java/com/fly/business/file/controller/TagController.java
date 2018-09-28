package com.fly.business.file.controller;

import com.fly.business.file.service.TagService;
import com.fly.pojo.FlyTag;
import com.fly.pojo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody FlyTag tag) {
        FlyTag res = tagService.save(tag);
        Result<FlyTag> result = new Result<>();
        return result.ok(res);
    }

    @GetMapping("/all")
    @ResponseBody
    public Result findAll() {
        List<FlyTag> tags = tagService.findAll();
        Result<List<FlyTag>> result = new Result<>();
        return result.ok(tags);
    }

    @GetMapping("/subject/{id}")
    @ResponseBody
    public Result findTagById(@PathVariable String id) {
        FlyTag res = tagService.findById(id);
        Result<FlyTag> result = new Result<>();
        return result.ok(res);
    }

    @GetMapping("/subjects/{tag_type}")
    @ResponseBody
    public Result find(Result result, @PathVariable("tag_type") String tagType) {
        List<FlyTag> tags = tagService.find(tagType);
        return result.ok(tags);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void deleteById(@PathVariable("id") String id) {
        tagService.deleteById(id);
    }

}
