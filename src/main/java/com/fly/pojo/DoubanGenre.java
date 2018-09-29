package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fly.enums.StatusEnum;
import com.fly.util.Util;

import javax.persistence.*;

@Entity
@Table(name = "douban_genre")
@JsonIgnoreProperties({"createTime", "updateTime", "status"})
public class DoubanGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String status = StatusEnum.ACTIVE.getName();
    @Column(name = "create_time")
    private String createTime = Util.getCurrentFormatTime();
    @Column(name = "update_time")
    private String updateTime = Util.getCurrentFormatTime();

    @Transient
    @JsonProperty("subject_count")
    private Long subjectCount;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(Long subjectCount) {
        this.subjectCount = subjectCount;
    }

    @Override
    public String toString() {
        return "DoubanGenre{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", subjectCount='" + subjectCount + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
