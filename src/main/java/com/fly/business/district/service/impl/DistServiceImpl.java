package com.fly.business.district.service.impl;

import com.fly.business.district.dao.CityDao;
import com.fly.business.district.dao.DistDao;
import com.fly.business.district.service.DistService;
import com.fly.pojo.DoubanCity;
import com.fly.pojo.DoubanDistrict;
import com.fly.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author david
 * @date 31/07/18 18:53
 */
@Service
public class DistServiceImpl implements DistService {

    @Autowired
    private CityDao cd;
    @Autowired
    private DistDao dd;

    @Override
    public List<DoubanCity> getTrees() {
        String name = null;
        DoubanCity parent = null;
        List<DoubanCity> cities = cd.findAll();
        List<DoubanDistrict> districts = dd.findAll();

        HashMap<Integer, DoubanCity> cityIdMap = new HashMap<>();
        HashMap<String, DoubanCity> cityNameMap = new HashMap<>();
        for (DoubanCity city : cities) {
            cityIdMap.put(city.getId(), city);
            cityNameMap.put(city.getName(), city);
        }

        // pack districts
        for(DoubanDistrict dist : districts) {
            Integer pid = dist.getPid();
            DoubanCity city = cityIdMap.get(pid);
            List<DoubanDistrict> dists = city.getDists();
            dists.add(dist);
        }

        Map<Integer, DoubanCity> parentMap = new HashMap<>();
        Integer pid = cd.findRootPid();
        for (DoubanCity city : cities) { // parent
            if (city.getPid().equals(pid)) {
                parentMap.put(city.getId(), city);
            }
        }

        for (DoubanCity city : cities) {
            Integer p = city.getPid();
            parent = parentMap.get(p);
            if (parent == null) {
                continue;
            }
            List<DoubanCity> children = parent.getCities();
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(city);
            parent.setCities(children);
            parentMap.put(p, parent);
        }

        return Util.getValuesFromMap(parentMap);
    }

    @Override
    public DoubanCity getTreesByName(String name) {
        DoubanCity city = cd.findByName(name);

        if(city == null) {
            throw new RuntimeException("city not found!");
        }

        List<DoubanDistrict> dists = dd.findByPid(city.getId());
        if (dists.size() != 0) {
            city.setDists(dists);
        }
        return city;
    }

}
