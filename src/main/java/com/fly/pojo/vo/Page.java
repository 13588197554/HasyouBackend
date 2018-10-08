package com.fly.pojo.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author david
 * @date 03/08/18 20:33
 */
@Data
public class Page<T> {

    private Integer total;
    private Integer page;
    private Integer count;
    private List<T> body = new ArrayList<>();
    private Map<Object, Object> extra = new HashMap<>();

}
