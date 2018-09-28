package com.fly.business.district.dao;

import com.fly.pojo.DoubanCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author david
 * @date 31/07/18 18:54
 */
@Repository
public interface CityDao extends JpaRepository<DoubanCity, Integer> {

    @Query("select c from DoubanCity c where name = :name")
    DoubanCity findByName(@Param("name") String name);

    @Query("select c.id from DoubanCity c where c.name = '中国'")
    Integer findRootPid();

    List<DoubanCity> findByPid(Integer pid);

}
