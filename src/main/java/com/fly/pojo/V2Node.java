package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fly.util.Util;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "v2_node")
@JsonIgnoreProperties({"createTime", "updateTime"})
public class V2Node implements Serializable {
    @Id
    private String id;
    private String name;
    private String title;
    @Column(name = "title_alternative")
    @JsonProperty("title_alternative")
    private String titleAlternative;
    private Integer topics;
    @Column(name = "create_time")
    private String createTime = Util.getCurrentFormatTime();
    @Column(name = "update_time")
    private String updateTime = Util.getCurrentFormatTime();

    public V2Node() {
    }

    public V2Node(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Transient
    @JsonProperty("post_count")
    private Integer postCount;
    @Transient
    private List<V2Post> posts = new ArrayList<>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleAlternative() {
        return titleAlternative;
    }

    public void setTitleAlternative(String titleAlternative) {
        this.titleAlternative = titleAlternative;
    }

    public Integer getTopics() {
        return topics;
    }

    public void setTopics(Integer topics) {
        this.topics = topics;
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

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public List<V2Post> getPosts() {
        return posts;
    }

    public void setPosts(List<V2Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "V2Node{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", titleAlternative='" + titleAlternative + '\'' +
                ", topics=" + topics +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", postCount=" + postCount +
                ", posts=" + posts +
                '}';
    }
}
