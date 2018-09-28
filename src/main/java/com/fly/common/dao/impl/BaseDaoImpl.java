package com.fly.common.dao.impl;

import com.fly.config.JpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author david
 * @date 23/08/18 20:31
 */
@Component
public class BaseDaoImpl<T, ID extends Serializable> {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private JpaConfig jpa;



}
