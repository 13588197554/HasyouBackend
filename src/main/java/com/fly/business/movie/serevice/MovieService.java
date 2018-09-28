package com.fly.business.movie.serevice;

import com.fly.pojo.DoubanMovie;
import com.fly.pojo.FlyTag;
import com.fly.pojo.vo.Page;

import java.util.List;

public interface MovieService {

    Long size();

    Page<DoubanMovie> findByPage(String type, Integer p, Integer count);

    List<FlyTag> findTags(String type);

    Page<DoubanMovie> findByTagId(String tagId, Integer p, Integer count);
}
