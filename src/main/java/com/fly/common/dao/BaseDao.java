package com.fly.common.dao;

import java.io.Serializable;

/**
 * @author david
 * @date 23/08/18 20:32
 */
public interface BaseDao<T, I extends Serializable> {

    T findById(String tableName, I i);

}
