package com.fly.business.district.dao;

import com.fly.pojo.DoubanDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author david
 * @date 31/07/18 18:55
 */
@Repository
public interface DistDao extends JpaRepository<DoubanDistrict, Integer> {

    List<DoubanDistrict> findByPid(Integer id);
}
