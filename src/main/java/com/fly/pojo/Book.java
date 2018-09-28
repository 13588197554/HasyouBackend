package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "douban_book")
@JsonIgnoreProperties({"author", "translator", "extra", "createTime", "updateTime", "status"})
public class Book implements Serializable {

    @Id
    private String id;
    private String name;
    @Column(name = "tag_id")
    @JsonProperty("tag_id")
    private String tagId;
    private String author;
    private String publisher;
    @Column(name = "origin_work_name")
    @JsonProperty("origin_title")
    private String originWorkName;
    private String translator;
    @Column(name = "publish_time")
    @JsonProperty("publish_time")
    private String publishTime;
    @Column(name = "page_count")
    @JsonProperty("page_count")
    private String pageCount;
    private String binding;
    private String price;
    @Column(name = "image_url")
    @JsonProperty("image_url")
    private String imageUrl;
    private String stars;
    private String intro;
    private String extra;
    private String status;
    @Column(name = "comments_count")
    @JsonProperty("comments_count")
    private Integer commentsCount;
    @Column(name = "reviews_count")
    @JsonProperty("reviews_count")
    private Integer reviewsCount;
    @Column(name = "create_time", length = 24)
    private String createTime;
    @Column(name = "update_time", length = 24)
    private String updateTime;

    @Transient
    private FlyTag tag;
    @Transient
    private List<String> authors;
    @Transient
    private List<String> translators;
    @Transient
    @JsonProperty("comment_count")
    private Long commentCount = 0L;
    @Transient
    private List<BookShortComment> comments;

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getOriginWorkName() {
        return originWorkName;
    }

    public void setOriginWorkName(String originWorkName) {
        this.originWorkName = originWorkName;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStars() {
        return stars;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public FlyTag getTag() {
        return tag;
    }

    public void setTag(FlyTag tag) {
        this.tag = tag;
    }

    public List<BookShortComment> getComments() {
        return comments;
    }

    public void setComments(List<BookShortComment> comments) {
        this.comments = comments;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getTranslators() {
        return translators;
    }

    public void setTranslators(List<String> translators) {
        this.translators = translators;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", originWorkName='" + originWorkName + '\'' +
                ", translator='" + translator + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", commentCount='" + commentCount + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tagId='" + tagId + '\'' +
                ", binding='" + binding + '\'' +
                ", price='" + price + '\'' +
                ", stars='" + stars + '\'' +
                ", intro='" + intro + '\'' +
                ", extra='" + extra + '\'' +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
