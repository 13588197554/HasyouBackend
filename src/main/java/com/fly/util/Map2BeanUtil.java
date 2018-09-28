package com.fly.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author david
 * @date 30/08/18 15:26
 */
public class Map2BeanUtil {

    public static <T> T map2Bean(Class<T> clazz, Map<String, Object> map) {
        try {
            T t = clazz.newInstance();
            Set<Map.Entry<String, Object>> set = map.entrySet();
            for (Map.Entry e : set) {
                String origin_key = (String) e.getKey();
                String fieldName = StringUtil.camel(origin_key);
                String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                Field field = clazz.getDeclaredField(fieldName);
                Class<?> type = field.getType();
                String fieldType = type.getSimpleName();
                Method m = null;
                if ("String".equals(fieldType)) {
                    m = clazz.getMethod(methodName, String.class);
                } else if ("Integer".equals(fieldType)) {
                    m = clazz.getMethod(methodName, Integer.class);
                } else if ("Date".equals(fieldType)) {
                    m = clazz.getMethod(methodName, Date.class);
                } else if ("Boolean".equals(fieldType)) {
                    m = clazz.getMethod(methodName, Boolean.class);
                } else if ("int".equals(fieldType)) {
                    m = clazz.getMethod(methodName, int.class);
                } else if ("boolean".equals(fieldType)) {
                    m = clazz.getMethod(methodName, boolean.class);
                } else if ("Float".equals(fieldType)) {
                    m = clazz.getMethod(methodName, Float.class);
                } else if ("Double".equals(fieldType)) {
                    m = clazz.getMethod(methodName, Double.class);
                } else if ("Long".equals(fieldType)) {
                    m = clazz.getMethod(methodName, Long.class);
                } else if ("long".equals(fieldType)) {
                    m = clazz.getMethod(methodName, long.class);
                }

                if (m != null) {
                    m.invoke(t, e.getValue());
                }
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> map2Bean(Class<T> clazz, List<Map<String, Object>> list) {
        try {
            List<T> res = new ArrayList<>();
            for (Map<String, Object> map : list) {
                T t = clazz.newInstance();
                Set<Map.Entry<String, Object>> set = map.entrySet();
                for (Map.Entry e : set) {
                    String originKey = (String) e.getKey();
                    String fieldName = StringUtil.camel(originKey);
                    String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                    Field field = clazz.getDeclaredField(fieldName);
                    String fieldType = field.getType().getSimpleName();
                    Method m = null;
                    if ("String".equals(fieldType)) {
                        m = clazz.getMethod(methodName, String.class);
                        String value = (String) e.getValue();
                        m.invoke(t, value);
                    } else if ("Integer".equals(fieldType)) {
                        m = clazz.getMethod(methodName, Integer.class);
                        Integer value = (Integer) e.getValue();
                        m.invoke(t, value);
                    } else if ("Date".equals(fieldType)) {
                        m = clazz.getMethod(methodName, Date.class);
                        Date value = (Date) e.getValue();
                        m.invoke(t, value);
                    } else if ("Boolean".equals(fieldType)) {
                        m = clazz.getMethod(methodName, Boolean.class);
                        Boolean value = (Boolean) e.getValue();
                        m.invoke(t, value);
                    } else if ("int".equals(fieldType)) {
                        m = clazz.getMethod(methodName, int.class);
                        int value = (int) e.getValue();
                        m.invoke(t, value);
                    } else if ("boolean".equals(fieldType)) {
                        m = clazz.getMethod(methodName, boolean.class);
                        boolean value = (boolean) e.getValue();
                        m.invoke(t, value);
                    } else if ("Float".equals(fieldType)) {
                        m = clazz.getMethod(methodName, Float.class);
                        Float value = (Float) e.getValue();
                        m.invoke(t, value);
                    } else if ("Double".equals(fieldType)) {
                        m = clazz.getMethod(methodName, Double.class);
                        Double value = (Double) e.getValue();
                        m.invoke(t, value);
                    } else if ("Long".equals(fieldType)) {
                        m = clazz.getMethod(methodName, Long.class);
                        Long value = (Long) e.getValue();
                        m.invoke(t, value);
                    } else if ("long".equals(fieldType)) {
                        m = clazz.getMethod(methodName, long.class);
                        Object o = map.get(e.getKey());
                        m.invoke(t, (long)o);
                    }

                }
                res.add(clazz.cast(t));
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}