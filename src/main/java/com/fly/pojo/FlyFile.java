package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "file")
@JsonIgnoreProperties({"status"})
public class FlyFile implements Serializable{
    @Id
    @Column(length = 32)
    private String id;
    @Column(name = "file_url")
    @JsonProperty("file_url")
    private String fileUrl;
    @NotEmpty
    @Column(name = "file_name")
    @JsonProperty("file_name")
    private String fileName;
    @Column(name = "tag_id")
    @JsonProperty("tag_id")
    private String tagId;
    @NotEmpty
    private String title;
    private String status;
    private FlyTag tag;
    @Column(name = "create_time", columnDefinition = "TIMESTAMP")
    @JsonProperty("create_time")
    private Timestamp createTime;
    @Column(name = "update_time", columnDefinition = "TIMESTAMP")
    @JsonProperty("update_time")
    private Timestamp updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public FlyTag getTag() {
        return tag;
    }

    public void setTag(FlyTag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "FlyFile{" +
                "id='" + id + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileName='" + fileName + '\'' +
                ", tagId='" + tagId + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", tag=" + tag +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
