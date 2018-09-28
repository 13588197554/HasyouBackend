package com.fly.business.event.controller;

import com.fly.business.event.service.EventService;
import com.fly.pojo.DoubanEvent;
import com.fly.pojo.vo.Page;
import com.fly.pojo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author david
 * @date 28/08/18 19:10
 */
@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService es;

    @GetMapping("/subjects")
    @ResponseBody
    public Result findByPage(Result result,
                             @RequestParam("loc_id") Integer locId,
                             @RequestParam(value = "p", defaultValue = "1") Integer p,
                             @RequestParam(value = "count", defaultValue = "20", required = true) Integer count) {
        Page<DoubanEvent> page = es.findByPage(locId, p, count);
        return result.ok(page);
    }

}
