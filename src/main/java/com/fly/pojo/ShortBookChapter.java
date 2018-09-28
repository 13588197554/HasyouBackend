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
@Table(name = "short_book_chapter")
@JsonIgnoreProperties({"status", "create_time", "update_time"})
public class ShortBookChapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "pid")
    @JsonProperty("pid")
    private Integer pid = -1;
    private String category;
    private String name;
    @Column(name = "short_book_id")
    @JsonProperty("short_book_id")
    private Integer shortBookId;
    @Column(length = 45)
    private String status = "ACTIVE";
    @Column(name = "create_time", length = 24)
    private String createTime;
    @Column(name = "update_time", length = 24)
    private String updateTime;

    @Transient
    private ShortBook shortBook;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getShortBookId() {
        return shortBookId;
    }

    public void setShortBookId(Integer shortBookId) {
        this.shortBookId = shortBookId;
    }

    public ShortBook getShortBook() {
        return shortBook;
    }

    public void setShortBook(ShortBook shortBook) {
        this.shortBook = shortBook;
    }

    @Override
    public String toString() {
        return "ShortBookChapter{" +
                "id=" + id +
                ", pid=" + pid +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", shortBookId=" + shortBookId +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", shortBook='" + shortBook + '\'' +
                '}';
    }
}
