package com.fly.business.movie.dao;

import com.fly.pojo.DoubanParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantDao extends JpaRepository<DoubanParticipant, String> {

    List<DoubanParticipant> findByName(String name);

}
