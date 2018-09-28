package com.fly.business.v2.dao;

import com.fly.pojo.V2Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MemberDao extends JpaRepository<V2Member, String> {

    @Query("select m from V2Member m where username = :username")
    V2Member findByUsername(@Param("username") String username);

    @Query("SELECT new V2Member(m.id, m.username, m.avatarMini, m.avatarNormal, m.avatarLarge, m.created) FROM V2Member m WHERE m.id IN :member_ids")
    List<V2Member> findByIds(@Param("member_ids") Set<String> memberIds);

    @Query("select m from V2Member m where m.username in :usernames")
    List<V2Member> findByUsernames(@Param("usernames") Set<String> authors);
}
