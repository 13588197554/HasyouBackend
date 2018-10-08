package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "douban_book")
@JsonIgnoreProperties({"author", "translator", "extra", "createTime", "updateTime", "status"})
public class Book implements Serializable {

    @Id
    private String id;
    private String name;
    @Column(name = "tag_id")
    private String tagId;
    private String author;
    private String publisher;
    @Column(name = "origin_work_name")
    private String originWorkName;
    private String translator;
    @Column(name = "publish_time")
    private String publishTime;
    @Column(name = "page_count")
    private String pageCount;
    private String binding;
    private String price;
    @Column(name = "image_url")
    private String imageUrl;
    private String stars;
    private String intro;
    private String extra;
    private String status;
    @Column(name = "comments_count")
    private Integer commentsCount;
    @Column(name = "reviews_count")
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
    private List<BookShortComment> comments;

}
