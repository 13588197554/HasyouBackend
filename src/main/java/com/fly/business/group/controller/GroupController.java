package com.fly.business.group.controller;

import com.fly.business.group.service.GroupService;
import com.fly.pojo.FlyGroup;
import com.fly.pojo.vo.InputParam;
import com.fly.pojo.vo.Result;
import com.fly.util.Arr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService gs;

    @GetMapping("/subjects")
    @ResponseBody
    public Result findGroups(Result result) {
        List<FlyGroup> groups = gs.findGroups();
        return result.ok(groups);
    }

    @PostMapping("/subject")
    @ResponseBody
    public Result save(Result result, @RequestBody InputParam param) {
        String name = Arr.get(param, "name", String.class);
        Integer pid = Arr.get(param, "pid", 0, Integer.class);
        String extra = Arr.get(param, "extra", "", String.class);
        FlyGroup group = gs.save(name, pid, extra);
        return result.ok(group);
    }

}
