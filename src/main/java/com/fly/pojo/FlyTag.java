package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag")
@JsonIgnoreProperties({"createTime", "updateTime", "status"})
public class FlyTag implements Serializable {

    @Id
    @Column(length = 32)
    private String id;
    @Column(name = "tag_name")
    @JsonProperty("tag_name")
    private String tagName;
    @Column(name = "pid")
    private String pid;
    @Column(name = "tag_type")
    @JsonProperty("tag_type")
    private String tagType;
    private String status;
    @Column(name = "create_time", columnDefinition = "timestamp", insertable = false, updatable = false)
    private Timestamp createTime;
    @Column(name = "create_time", columnDefinition = "timestamp", insertable = false, updatable = false)
    private Timestamp updateTime;

    @Transient
    private List<FlyTag> children = new ArrayList<>();
    @Transient
    @JsonProperty("subject_count")
    private Long subjectCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<FlyTag> getChildren() {
        return children;
    }

    public void setChildren(List<FlyTag> children) {
        this.children = children;
    }

    public Long getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(Long subjectCount) {
        this.subjectCount = subjectCount;
    }

    @Override
    public String toString() {
        return "FlyTag{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", tagName='" + tagName + '\'' +
                ", tagType='" + tagType + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
