package com.fly.business.music.dao;

import com.fly.pojo.DoubanMusic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicDao extends JpaRepository<DoubanMusic, Integer>{
}
