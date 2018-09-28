package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * @author david
 * @date 22/09/18 13:13
 */
@Entity
@Table(name = "douban_movie_review")
public class DoubanMovieReview {

    @Id
    private Integer id;
    private Float stars;
    @Column(name = "useful_count")
    @JsonProperty("useful_count")
    private Integer usefulCount;
    @Column(name = "useless_count")
    @JsonProperty("useless_count")
    private Integer uselessCount;
    @Column(name = "comments_count")
    @JsonProperty("comments_count")
    private Integer commentsCount;
    @Column(name = "created_at")
    @JsonProperty("created_at")
    private String createdAt;
    @Column(length = 4096)
    private String title;
    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    private String updatedAt;
    @Column(name = "share_url")
    @JsonProperty("share_url")
    private String shareUrl;
    @Column(columnDefinition = "TEXT")
    private String summary;
    @Column(columnDefinition = "MediumText")
    private String content;
    private String alt;
    @Column(name = "subject_id")
    @JsonProperty("subject_id")
    private String subjectId;

    @Transient
    private DoubanUser author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getStars() {
        return stars;
    }

    public void setStars(Float stars) {
        this.stars = stars;
    }

    public Integer getUsefulCount() {
        return usefulCount;
    }

    public void setUsefulCount(Integer usefulCount) {
        this.usefulCount = usefulCount;
    }

    public Integer getUselessCount() {
        return uselessCount;
    }

    public void setUselessCount(Integer uselessCount) {
        this.uselessCount = uselessCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public DoubanUser getAuthor() {
        return author;
    }

    public void setAuthor(DoubanUser author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "DoubanMovieReview{" +
                "id=" + id +
                ", stars=" + stars +
                ", usefulCount=" + usefulCount +
                ", uselessCount=" + uselessCount +
                ", commentsCount=" + commentsCount +
                ", createdAt='" + createdAt + '\'' +
                ", title='" + title + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", alt='" + alt + '\'' +
                ", subjectId='" + subjectId + '\'' +
                '}';
    }
}
