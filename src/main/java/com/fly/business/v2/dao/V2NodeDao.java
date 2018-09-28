package com.fly.business.v2.dao;

import com.fly.pojo.V2Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface V2NodeDao extends JpaRepository<V2Node, String> {

    List<V2Node> findByName(String nodeName);

    @Query("SELECT n FROM V2Node n WHERE id IN :member_ids")
    List<V2Node> findByIds(@Param("member_ids") Set<String> memberIds);
}
