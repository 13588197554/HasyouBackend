package com.fly.pojo.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author david
 * @date 03/08/18 20:33
 */
public class Page<T> {

    private Long total;
    private Integer page;
    private Integer count;
    private List<T> body = new ArrayList<>();
    private Map<Object, Object> extra = new HashMap<>();

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getBody() {
        return body;
    }

    public void setBody(List<T> body) {
        this.body = body;
    }

    public Map<Object, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<Object, Object> extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", page=" + page +
                ", count=" + count +
                ", body=" + body +
                ", extra=" + extra +
                '}';
    }
}
