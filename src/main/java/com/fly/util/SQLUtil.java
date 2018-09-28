package com.fly.util;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class SQLUtil<T> {

    public T first(String sql, Class<T> clazz, EntityManager em) {
        Query query = em.createNativeQuery(sql);
        query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        Map map = (Map) query.getSingleResult();
        Object o = Map2BeanUtil.map2Bean(clazz, map);
        return clazz.cast(o);
    }

    public T first(String sql, Class<T> clazz, EntityManager em, Map<String, Object> params) {
        Query query = em.createNativeQuery(sql);
        query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        Set<Map.Entry<String, Object>> entries = params.entrySet();
        for (Map.Entry<String, Object> e : entries) {
            query.setParameter(e.getKey(), e.getValue());
        }
        Map map = (Map) query.getSingleResult();
        Object o = Map2BeanUtil.map2Bean(clazz, map);
        return clazz.cast(o);
    }

    public List<T> get(String sql, Class<T> clazz, EntityManager em) {
        Query query = em.createNativeQuery(sql);
        query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list = query.getResultList();
        list = Map2BeanUtil.map2Bean(clazz, list);
        return list;
    }

    public List<T> get(String sql, Class<T> clazz, EntityManager em, Map<String, Object> params) {
        Query query = em.createNativeQuery(sql);
        query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        Set<Map.Entry<String, Object>> entries = params.entrySet();
        for (Map.Entry<String, Object> e : entries) {
            query.setParameter(e.getKey(), e.getValue());
        }
        List list = query.getResultList();
        list = Map2BeanUtil.map2Bean(clazz, list);
        return list;
    }

}
