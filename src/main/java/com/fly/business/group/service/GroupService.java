package com.fly.business.group.service;

import com.fly.pojo.FlyGroup;

import java.util.List;

public interface GroupService {

    List<FlyGroup> findGroups();

    FlyGroup save(String name, Integer pid, String extra);
}
