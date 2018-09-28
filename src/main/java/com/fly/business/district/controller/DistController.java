package com.fly.business.district.controller;

import com.fly.business.district.service.DistService;
import com.fly.pojo.DoubanCity;
import com.fly.pojo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author david
 * @date 31/07/18 18:48
 */
@Controller
@RequestMapping("/dist")
public class DistController {

    @Autowired
    private DistService ds;

    @GetMapping("/china/trees")
    @ResponseBody
    public Result<List> getTrees(Result<List> result) {
        List<DoubanCity> list = ds.getTrees();
        result.ok(list);
        return result;
    }

    @GetMapping("/trees/{name}")
    @ResponseBody
    public Result<DoubanCity> getTreesByName(@PathVariable("name") String name, Result result) {
        DoubanCity city = ds.getTreesByName(name);
        result.ok(city);
        return result;
    }

}
