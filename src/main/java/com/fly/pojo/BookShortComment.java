package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "douban_book_short_comment")
@JsonIgnoreProperties({"updateTime", "status"})
@Data
public class BookShortComment implements Serializable {

    @Id
    private String id;
    private String content;
    @Column(name = "book_id")
    private String bookId;
    private String stars;
    @Column(name = "creator_name")
    private String creatorName;
    @Column(name = "creator_href")
    private String creatorHref;
    @Column(name = "created")
    private String created;
    private Integer votes;
    private String status;
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "update_time")
    private String updateTime;

}
