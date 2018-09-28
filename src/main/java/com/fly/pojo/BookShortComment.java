package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "douban_book_short_comment")
@JsonIgnoreProperties({"updateTime", "status"})
public class BookShortComment implements Serializable {

    @Id
    private String id;
    private String content;
    @Column(name = "book_id")
    @JsonProperty("book_id")
    private String bookId;
    private String stars;
    @Column(name = "creator_name")
    @JsonProperty("creator_name")
    private String creatorName;
    @Column(name = "creator_href")
    @JsonProperty("creator_href")
    private String creatorHref;
    @Column(name = "created")
    private String created;
    @Column(name = "helpful_count")
    @JsonProperty("helpful_count")
    private Integer helpfulCount;
    private String status;
    @Column(name = "create_time")
    @JsonProperty("create_time")
    private String createTime;
    @Column(name = "update_time")
    private String updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatorHref() {
        return creatorHref;
    }

    public void setCreatorHref(String creatorHref) {
        this.creatorHref = creatorHref;
    }

    public Integer getHelpfulCount() {
        return helpfulCount;
    }

    public void setHelpfulCount(Integer helpfulCount) {
        this.helpfulCount = helpfulCount;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
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

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "BookShortComment{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", bookId='" + bookId + '\'' +
                ", stars='" + stars + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", creatorHref='" + creatorHref + '\'' +
                ", helpfulCount=" + helpfulCount +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
