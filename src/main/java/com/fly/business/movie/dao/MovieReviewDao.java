package com.fly.business.movie.dao;

import com.fly.pojo.DoubanMovieReview;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author david
 * @date 22/09/18 13:20
 */
public interface MovieReviewDao extends JpaRepository<DoubanMovieReview, Integer> {
}
