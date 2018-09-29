package com.fly.business.music.service.impl;

import com.fly.business.music.dao.MusicDao;
import com.fly.business.music.service.MusicService;
import com.fly.common.dao.TagObjectDao;
import com.fly.pojo.DoubanMusic;
import com.fly.pojo.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService{

    @Autowired
    private MusicDao md;
    @Autowired
    private TagObjectDao tod;

    @Override
    public Page<DoubanMusic> findByTagId(String tagId, Integer p, Integer count) {
        List<String> ids = tod.findIdsByTagIdAndPage(tagId, p, count);
        List<Integer> tagIds = new ArrayList<>();
        ids.forEach( id -> { tagIds.add(Integer.valueOf(id));});
        List<DoubanMusic> musics = md.findAllById(tagIds);
        Page<DoubanMusic> page = new Page<>();
        page.setPage(p);
        page.setCount(count);
        page.setBody(musics);
        return page;
    }
}
