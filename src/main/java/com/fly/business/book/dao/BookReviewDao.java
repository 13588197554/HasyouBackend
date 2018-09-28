package com.fly.business.book.dao;

import com.fly.pojo.DoubanBookReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewDao extends JpaRepository<DoubanBookReview, Integer> {
}
