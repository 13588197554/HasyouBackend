package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "douban_book_review")
public class DoubanBookReview {

    @Id
    private Integer id;
    private Integer votes;
    private String title;
    private String updated;
    private String published;
    private String alt;
    private Integer comments;
    private Integer useless;
    @Column(columnDefinition = "MediumText")
    private String summary;
    @Column(name = "book_id")
    @JsonProperty("book_id")
    private String bookId;

    @Transient
    private DoubanUser author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getUseless() {
        return useless;
    }

    public void setUseless(Integer useless) {
        this.useless = useless;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public DoubanUser getAuthor() {
        return author;
    }

    public void setAuthor(DoubanUser author) {
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "DoubanBookReview{" +
                "id=" + id +
                ", votes=" + votes +
                ", title='" + title + '\'' +
                ", updated='" + updated + '\'' +
                ", published='" + published + '\'' +
                ", alt='" + alt + '\'' +
                ", comments=" + comments +
                ", useless=" + useless +
                ", summary='" + summary + '\'' +
                ", author=" + author +
                '}';
    }
}
