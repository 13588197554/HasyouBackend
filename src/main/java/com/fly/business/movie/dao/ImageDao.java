package com.fly.business.movie.dao;

import com.fly.pojo.DoubanImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ImageDao extends JpaRepository<DoubanImage, Integer> {

    @Query("select i from DoubanImage i where i.fk in :movie_ids")
    List<DoubanImage> findAllByMovieIds(@Param("movie_ids") List<String> movieIds);

    @Query("select i from DoubanImage i where i.fk in :movie_ids")
    List<DoubanImage> findAllByMovieIds(@Param("movie_ids") Set<String> movieIds);
}
