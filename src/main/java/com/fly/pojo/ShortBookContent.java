package com.fly.pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;

/**
 * @param
 * @author: 轻舞飞扬
 * Date: 2018-08-10
 */
@Entity
@Table(name = "short_book_content")
@JsonIgnoreProperties({"status", "create_time", "update_time"})
public class ShortBookContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "short_book_id")
    @JsonProperty("short_book_id")
    private Integer shortBookId;
    @Column(name = "chapter_id")
    @JsonProperty("chapter_id")
    private Integer chapterId;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(length = 45)
    private String status = "ACTIVE";
    @Column(name = "create_time", length = 24)
    @JsonProperty("create_time")
    private String createTime;
    @Column(name = "update_time", length = 24)
    @JsonProperty("update_time")
    private String updateTime;

    @Transient
    private ShortBook shortBook = new ShortBook();
    @Transient
    private ShortBookChapter shortBookChapter = new ShortBookChapter();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShortBookId() {
        return shortBookId;
    }

    public void setShortBookId(Integer shortBookId) {
        this.shortBookId = shortBookId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public ShortBook getShortBook() {
        return shortBook;
    }

    public void setShortBook(ShortBook shortBook) {
        this.shortBook = shortBook;
    }

    public ShortBookChapter getShortBookChapter() {
        return shortBookChapter;
    }

    public void setShortBookChapter(ShortBookChapter shortBookChapter) {
        this.shortBookChapter = shortBookChapter;
    }

    @Override
    public String toString() {
        return "ShortBookContent{" +
                "id=" + id +
                ", shortBookId=" + shortBookId +
                ", chapterId=" + chapterId +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", shortBook='" + shortBook + '\'' +
                ", shortBookChapter='" + shortBookChapter + '\'' +
                '}';
    }
}
