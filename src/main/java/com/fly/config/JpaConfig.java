package com.fly.config;

import com.fly.exception.SqlErrorException;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author david
 * @date 23/08/18 13:04
 */
@Component
public class JpaConfig<T, ID extends Serializable> {

    private static StringBuffer sb = new StringBuffer();

    /* select */
    public JpaConfig select(String...keys) {
        if (!sb.toString().contains("SELECT")) {
            sb.append(" SELECT ");
        } else {
            sb.append(", ");
        }

        for (int i = 0; i < keys.length;i++) {
            if (i != keys.length - 1) {
                sb.append(keys[i] + ", ");
                continue;
            }
            sb.append(keys[i]);
        }
        return this;
    }

    public JpaConfig select(String pattern) {
        sb.append("SELECT ");
        sb.append(pattern);
        return this;
    }

    /* from */
    public JpaConfig from(String tableName) {
        sb.append(" FROM " + tableName);
        return this;
    }

    /* where */
    public JpaConfig where(String key, String value) {
        if (sb.toString().contains("WHERE")) {
            sb.append(", " + key + " = " + "'" + value + "'");
        } else {
            sb.append(" WHERE " + key + " = " + "'" + value + "'");
        }
        return this;
    }

    public JpaConfig where(String key, Integer value) {
        if (sb.toString().contains("WHERE")) {
            sb.append(", " + key + " = " + value);
        } else {
            sb.append(" WHERE " + key + " = " + value);
        }
        return this;
    }

    public JpaConfig where(String key, Float value) {
        if (sb.toString().contains("WHERE")) {
            sb.append(", " + key + " = " + value);
        } else {
            sb.append(" WHERE " + key + " = " + value);
        }
        return this;
    }

    public JpaConfig where(String key, Double value) {
        if (sb.toString().contains("WHERE")) {
            sb.append(", " + key + " = " + value);
        } else {
            sb.append(" WHERE " + key + " = " + value);
        }
        return this;
    }

    public JpaConfig where(String key, ID value) {
        if (sb.toString().contains("WHERE")) {
            sb.append(", " + key + " = " + value);
        } else {
            sb.append(" WHERE " + key + " = " + value);
        }
        return this;
    }

    public JpaConfig where(String key, String pattern, String value) {
        if (sb.toString().contains("WHERE")) {
            sb.append(", " + key + " " + pattern + " '" + value + "'");
        } else {
            sb.append(" WHERE " + key + " " + pattern + " '" + value + "'");
        }
        return this;
    }

    public JpaConfig where(String key, String pattern, Integer value) {
        if (sb.toString().contains("WHERE")) {
            sb.append(", " + key + " " + pattern + " " + value);
        } else {
            sb.append(" WHERE " + key + " " + pattern + " " + value);
        }
        return this;
    }

    public JpaConfig where(String key, String pattern, Float value) {
        if (sb.toString().contains("WHERE")) {
            sb.append(", " + key + " " + pattern + " " + value);
        } else {
            sb.append(" WHERE " + key + " " + pattern + " " + value);
        }
        return this;
    }

    public JpaConfig where(String key, String pattern, Double value) {
        if (sb.toString().contains("WHERE")) {
            sb.append(", " + key + " " + pattern + " " + value);
        } else {
            sb.append(" WHERE " + key + " " + pattern + " " + value);
        }
        return this;
    }

    public JpaConfig where(String key, String pattern, ID value) {
        if (sb.toString().contains("WHERE")) {
            sb.append(", " + key + " " + pattern + " '" + value + "'");
        } else {
            sb.append(" WHERE " + key + " " + pattern + " '" + value + "'");
        }
        return this;
    }

    /* order by */
    public JpaConfig orderBy(String column, Boolean ascend) {
        String sort = ascend == true ? "asc" : "desc";
        if (sb.toString().contains("ORDER BY")) {
            sb.append(" ORDER BY " + column + " " + sort);
        } else {
            sb.append(", " + column + " " + sort);
        }
        return this;
    }

    /*count*/
    public JpaConfig count(String condition) {
        if (sb.toString().trim().startsWith("SELECT")) {
            sb.append(" COUNT(" + condition + ") ");
        } else {
            sb.append("SELECT COUNT(" + condition + ") ");
        }
        return this;
    }

    /* limit */
    public JpaConfig limit(Integer start, Integer count) {
        if (sb.toString().contains("LIMIT")) {
            throw new SqlErrorException("Sql error: " + sb.toString());
        }
        sb.append(" LIMIT " + start + ", " + count);
        return this;
    }

    public JpaConfig groupBy(String column) {
        sb.append(" GROUP BY " + column);
        return this;
    }

    public Object first(EntityManager em, Class clazz) {
        try {
            Query query = em.createNativeQuery(sb.toString(), clazz);
            Object o = query.getSingleResult();
            return o;
        } finally {
            sb.delete(0, sb.length());
        }
    }

    public List<Map> get(EntityManager em, Class clazz) {
        try {
            Query query = em.createNativeQuery(sb.toString(), clazz);
            query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            List result = query.getResultList();
            return result;
        } finally {
            sb.delete(0, sb.length());
        }
    }

    public Map<String, Object> first(EntityManager em) {
        try {
            Query query = em.createNativeQuery(sb.toString());
            query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            Map<String, Object> map = (Map<String, Object>) query.getSingleResult();
            return map;
        } finally {
            sb.delete(0, sb.length());
        }
    }

    public Map<String, Object> get(EntityManager em) {
        try {
            Query query = em.createNativeQuery(sb.toString());
            query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            Map<String, Object> map = (Map<String, Object>) query.getSingleResult();
            return map;
        } finally {
            sb.delete(0, sb.length());
        }
    }

}
