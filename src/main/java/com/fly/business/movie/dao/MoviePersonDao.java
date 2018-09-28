package com.fly.business.movie.dao;

import com.fly.pojo.DoubanMoviePerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoviePersonDao extends JpaRepository<DoubanMoviePerson, Integer> {


    @Query("select mp from DoubanMoviePerson mp where mp.movieId in :movie_ids")
    List<DoubanMoviePerson> findAllByMovieIds(@Param("movie_ids") List<String> movieIds);
}
