package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * @author david
 * @date 27/08/18 18:03
 */
@Entity
@Table(name = "douban_music")
public class DoubanMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String alt;
    private String author;
    private String stars;
    @Column(name = "alt_title")
    @JsonProperty("alt_title")
    private String altTitle;
    private String image;
    @Column(name = "mobile_link")
    @JsonProperty("mobile_link")
    private String mobileLink;
    private String publisher;
    private String singer;
    private String version;
    private String pubdate;
    private String aka;
    private String media;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String tracks;
    private String discs;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String extra;
    @Column(name = "create_time", length = 24)
    @JsonProperty("create_time")
    private String createTime;
    @Column(name = "update_time", length = 24)
    @JsonProperty("update_time")
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getAltTitle() {
        return altTitle;
    }

    public void setAltTitle(String altTitle) {
        this.altTitle = altTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getAka() {
        return aka;
    }

    public void setAka(String aka) {
        this.aka = aka;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public String getDiscs() {
        return discs;
    }

    public void setDiscs(String discs) {
        this.discs = discs;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
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
        return "DoubanMusic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", alt='" + alt + '\'' +
                ", author='" + author + '\'' +
                ", stars=" + stars +
                ", altTitle='" + altTitle + '\'' +
                ", image='" + image + '\'' +
                ", mobileLink='" + mobileLink + '\'' +
                ", publisher='" + publisher + '\'' +
                ", singer='" + singer + '\'' +
                ", version='" + version + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", aka='" + aka + '\'' +
                ", media='" + media + '\'' +
                ", tracks='" + tracks + '\'' +
                ", discs='" + discs + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
