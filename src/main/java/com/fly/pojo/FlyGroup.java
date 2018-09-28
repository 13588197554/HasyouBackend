package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fly.enums.StatusEnum;
import com.fly.util.Util;

import javax.persistence.*;

@Entity
@Table(name = "fly_group", indexes = {})
@JsonIgnoreProperties({"createTime", "updateTime", "status"})
public class FlyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer pid;
    private String name;
    private String extra;
    @Column(length = 45)
    private String status = StatusEnum.ACTIVE.getName();
    @Column(length = 24)
    private String createTime = Util.getCurrentFormatTime();
    @Column(length = 24)
    private String updateTime = Util.getCurrentFormatTime();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "FlyGroup{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", extra='" + extra + '\'' +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
