package com.fly.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fly.util.Util;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "v2_member")
@JsonIgnoreProperties({"createTime", "updateTime", "imgPrfix", "status"})
public class V2Member implements Serializable {
    @Id
    private String id;
    private String username;
    private String tagline;
    @Column(name = "avatar_mini")
    @JsonProperty("avatar_mini")
    private String avatarMini;
    @Column(name = "avatar_normal")
    @JsonProperty("avatar_normal")
    private String avatarNormal;
    @Column(name = "avatar_large")
    @JsonProperty("avatar_large")
    private String avatarLarge;
    private String url;
    private String website;
    private String twitter;
    private String psn;
    private String github;
    private String btc;
    private String location;
    private String status;
    private Long created;
    @Column(name = "create_time")
    private String createTime = Util.getCurrentFormatTime();
    @Column(name = "update_time")
    private String updateTime = Util.getCurrentFormatTime();

    public V2Member() {
    }

    public V2Member(String id, String username, String avatarMini, String avatarNormal, String avatarLarge, Long created) {
        this.id = id;
        this.username = username;
        this.avatarMini = avatarMini;
        this.avatarNormal = avatarNormal;
        this.avatarLarge = avatarLarge;
        this.created = created;
    }

    @Transient
    private String imgPrfix = "http:";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
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

    public String getAvatarMini() {
        return avatarMini;
    }

    public void setAvatarMini(String avatarMini) {
        this.avatarMini = this.imgPrfix + avatarMini;
    }

    public String getAvatarNormal() {
        return avatarNormal;
    }

    public void setAvatarNormal(String avatarNormal) {
        this.avatarNormal = this.imgPrfix + avatarNormal;
    }

    public String getAvatarLarge() {
        return avatarLarge;
    }

    public void setAvatarLarge(String avatarLarge) {
        this.avatarLarge = this.imgPrfix + avatarLarge;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getBtc() {
        return btc;
    }

    public void setBtc(String btc) {
        this.btc = btc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getImgPrfix() {
        return imgPrfix;
    }

    public void setImgPrfix(String imgPrfix) {
        this.imgPrfix = imgPrfix;
    }

    @Override
    public String toString() {
        return "V2Member{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", tagline='" + tagline + '\'' +
                ", avatarMini='" + avatarMini + '\'' +
                ", avatarNormal='" + avatarNormal + '\'' +
                ", avatarLarge='" + avatarLarge + '\'' +
                ", url='" + url + '\'' +
                ", website='" + website + '\'' +
                ", twitter='" + twitter + '\'' +
                ", psn='" + psn + '\'' +
                ", github='" + github + '\'' +
                ", btc='" + btc + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", created='" + created + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", imgPrfix='" + imgPrfix + '\'' +
                '}';
    }
}
