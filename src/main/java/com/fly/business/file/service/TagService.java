package com.fly.business.file.service;

import com.fly.pojo.FlyTag;

import java.util.List;

public interface TagService {
    FlyTag save(FlyTag tag);

    List<FlyTag> findAll();

    void deleteById(String id);

    FlyTag findById(String id);

    List<FlyTag> find(String tagType);
}
