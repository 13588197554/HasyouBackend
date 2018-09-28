package com.fly.business.group.service.impl;

import com.fly.business.group.dao.GroupDao;
import com.fly.business.group.service.GroupService;
import com.fly.pojo.FlyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao gd;

    @Override
    public List<FlyGroup> findGroups() {
        List<FlyGroup> groups = gd.findAll();
        return groups;
    }

    @Override
    public FlyGroup save(String name, Integer pid, String extra) {
        FlyGroup group = new FlyGroup();
        group.setName(name);
        group.setPid(pid);
        group.setExtra(extra);
        group = gd.save(group);
        return group;
    }
}
