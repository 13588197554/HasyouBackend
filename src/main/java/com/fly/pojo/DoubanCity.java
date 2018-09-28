package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fly.util.Util;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author david
 * @date 18/07/18 20:03
 */
@Entity
@Table(name = "douban_city")
@JsonFormat
@JsonIgnoreProperties({"spider", "status", "createTime", "updateTime"})
public class DoubanCity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(name = "pid")
    private Integer pid;
    @Column(name = "uid")
    private String uid;
    private String parent;
    private String habitable;
    @Column(name = "is_event")
    private int spider;
    private String status = "ACTIVE";
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "update_time")
    private String updateTime;

    @Transient
    private List<DoubanDistrict> dists = new ArrayList<>();
    @Transient
    List<DoubanCity> cities = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getHabitable() {
        return habitable;
    }

    public void setHabitable(String habitable) {
        this.habitable = habitable;
    }

    public String getCreateTime() {
        if (this.createTime == null) {
            this.createTime = Util.getCurrentFormatTime();
        }
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        if (this.updateTime == null) {
            this.updateTime = Util.getCurrentFormatTime();
        }
        return updateTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSpider() {
        return spider;
    }

    public void setSpider(int spider) {
        this.spider = spider;
    }

    public List<DoubanDistrict> getDists() {
        return dists;
    }

    public void setDists(List<DoubanDistrict> dists) {
        this.dists = dists;
    }

    public List<DoubanCity> getCities() {
        return cities;
    }

    public void setCities(List<DoubanCity> cities) {
        this.cities = cities;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "DoubanCity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                ", parent='" + parent + '\'' +
                ", habitable='" + habitable + '\'' +
                ", spider=" + spider +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", dists=" + dists +
                ", cities=" + cities +
                '}';
    }
}
