package com.fly.pojo;

import com.fly.enums.StatusEnum;
import com.fly.util.Util;

import javax.persistence.*;

@Entity
@Table(name = "douban_participant")
public class DoubanParticipant {

    @Id
    private String id;
    private String type;
    private String alt;
    private String name;
    private String status = StatusEnum.ACTIVE.getName();
    @Column(name = "create_time")
    private String createTime = Util.getCurrentFormatTime();
    @Column(name = "update_time")
    private String updateTime = Util.getCurrentFormatTime();

    @Transient
    private DoubanImage image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoubanImage getImage() {
        return image;
    }

    public void setImage(DoubanImage image) {
        this.image = image;
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

    @Override
    public String toString() {
        return "DoubanParticipant{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", alt='" + alt + '\'' +
                ", name='" + name + '\'' +
                ", image=" + image +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
