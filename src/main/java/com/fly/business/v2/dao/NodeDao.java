package com.fly.business.v2.dao;

import com.fly.pojo.V2Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeDao extends JpaRepository<V2Node, String> {

    @Query(value = "SELECT * FROM v2_node ORDER BY topics DESC limit :start, :count", nativeQuery = true)
    List<V2Node> findByPage(@Param("start") Integer start, @Param("count") Integer count);

    @Query(value = "SELECT DISTINCT * FROM v2_node n WHERE n.name LIKE :k or n.title LIKE :k or n.title_alternative LIKE :k", nativeQuery = true)
    List<V2Node> search(@Param("k") String keywords);
}
