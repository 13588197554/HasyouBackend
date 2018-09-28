package com.fly.business.group.dao;

import com.fly.pojo.FlyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupDao extends JpaRepository<FlyGroup, Integer> {

}
