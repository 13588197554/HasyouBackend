package com.fly.business.movie.dao;

import com.fly.pojo.DoubanGenre;
import com.fly.pojo.DoubanMovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreDao extends JpaRepository<DoubanGenre, Integer> {

    DoubanGenre findByName(String name);

    @Query("select mg from DoubanMovieGenre mg where mg.movieId in :ids")
    List<DoubanMovieGenre> findAllByMovieIds(@Param("ids") List<String> ids);
}
