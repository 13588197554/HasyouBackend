package com.fly.business.event.service.impl;

import com.fly.business.event.dao.EventDao;
import com.fly.business.event.service.EventService;
import com.fly.pojo.DoubanEvent;
import com.fly.pojo.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author david
 * @date 28/08/18 19:10
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao ed;

    @Override
    public Page<DoubanEvent> findByPage(Integer locId, Integer p, Integer count) {
        Integer start = (p - 1) * count;
        List<DoubanEvent> events = ed.findByPage(locId, start, count);
        Page<DoubanEvent> page = new Page<>();
        page.setBody(events);
        return page;
    }

}
