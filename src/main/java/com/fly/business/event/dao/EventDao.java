package com.fly.business.event.dao;

import com.fly.pojo.DoubanEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author david
 * @date 28/08/18 19:10
 */
public interface EventDao extends JpaRepository<DoubanEvent, String> {

    @Query(nativeQuery = true, value = "select * from douban_event where loc_id = :loc_id order by begin_time desc limit :start, :count")
    List<DoubanEvent> findByPage(@Param("loc_id") Integer locId, @Param("start") Integer start, @Param("count") Integer count);

}
