package com.fly.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fly.util.Util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "douban_user")
public class DoubanUser implements Serializable {

    @Id
    private String id;
    private String name;
    @Column(name = "uid")
    private String uid;
    @Column(name = "loc_id")
    private String locId;
    @JSONField(name = "desc")
    private String description;
    private String type;
    private String signature;
    private String avatar;
    @Column(name = "large_avatar")
    private String largeAvatar;
    private String created;
    @Column(name = "is_banned")
    private boolean banned;
    @Column(name = "is_suicide")
    private boolean suicide;
    private String alt;
    @Column(name = "create_time")
    private String creatTime;
    @Column(name = "update_time")
    private String updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLargeAvatar() {
        return largeAvatar;
    }

    public void setLargeAvatar(String largeAvatar) {
        this.largeAvatar = largeAvatar;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public boolean isSuicide() {
        return suicide;
    }

    public void setSuicide(boolean suicide) {
        this.suicide = suicide;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getCreatTime() {
        if (this.creatTime == null) {
            this.creatTime = Util.getCurrentFormatTime();
        }
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
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
        return "DoubanUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                ", locId='" + locId + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", signature='" + signature + '\'' +
                ", avatar='" + avatar + '\'' +
                ", largeAvatar='" + largeAvatar + '\'' +
                ", created='" + created + '\'' +
                ", banned=" + banned +
                ", suicide=" + suicide +
                ", alt='" + alt + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
