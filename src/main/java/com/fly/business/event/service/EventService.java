package com.fly.business.event.service;

import com.fly.pojo.DoubanEvent;
import com.fly.pojo.vo.Page;

/**
 * @author david
 * @date 28/08/18 19:10
 */
public interface EventService {
    Page<DoubanEvent> findByPage(Integer locId, Integer p, Integer count);
}
