package com.fly.business.movie.dao;

import com.fly.pojo.DoubanMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieDao extends JpaRepository<DoubanMovie, String> {

    @Query(nativeQuery = true, value = "select * from douban_movie where subtype = :type order by average desc limit :start, :count")
    List<DoubanMovie> findByPage(@Param("type") String type, @Param("start") Integer start, @Param("count") Integer count);

}
