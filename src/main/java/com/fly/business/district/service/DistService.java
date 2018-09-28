package com.fly.business.district.service;

import com.fly.pojo.DoubanCity;

import java.util.List;

/**
 * @author david
 * @date 31/07/18 18:53
 */
public interface DistService {

    List<DoubanCity> getTrees();

    DoubanCity getTreesByName(String name);

}
