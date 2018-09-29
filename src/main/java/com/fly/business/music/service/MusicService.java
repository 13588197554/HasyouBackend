package com.fly.business.music.service;

import com.fly.pojo.DoubanMusic;
import com.fly.pojo.vo.Page;

public interface MusicService {

    Page<DoubanMusic> findByTagId(String tagId, Integer p, Integer count);

}
