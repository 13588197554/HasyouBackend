package com.fly.business.movie.dao;

import com.fly.pojo.DoubanMovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface MovieGenreDao extends JpaRepository<DoubanMovieGenre, Integer> {

    @Query(nativeQuery = true, value = "SELECT genre_id, COUNT(1) FROM fly.douban_movie_genre GROUP BY genre_id " +
            "HAVING genre_id IN :genre_ids")
    List<Map<Integer, Object>> countByIds(@Param("genre_ids") List<Integer> genreIds);

    @Query(nativeQuery = true, value = "SELECT DISTINCT movie_id FROM douban_movie_genre WHERE genre_id = :genre_id" +
            " limit :start, :count")
    List<String> findIdsByGenreIdAndPage(@Param("genre_id") String genreId,
                                         @Param("start") Integer start,
                                         @Param("count") Integer count);
}
