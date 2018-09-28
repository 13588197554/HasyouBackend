package com.fly.business.file.dao;

import com.fly.pojo.FlyFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author david
 * @date 22/08/18 13:12
 */
public interface FileDao extends JpaRepository<FlyFile, String> {

    List<FlyFile> findByTitle(String title);

}
