package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "v2_post")
@JsonIgnoreProperties(value = {"node_id", "created", "member_id", "update_time", "is_spider"})
public class V2Post implements Serializable {

    @Id
    private String id;
    private String type;
    private String title;
    private String url;
    private String content;
    private Integer created;
    @Column(name = "last_modified")
    @JsonProperty("last_modified")
    private Integer lastModified;
    @Column(name = "last_touched")
    @JsonProperty("last_touched")
    private Integer lastTouched;
    @Column(name = "node_id")
    @JsonProperty("node_id")
    private String nodeId;
    @Column(name = "member_id")
    @JsonProperty("member_id")
    private String memberId;
    @Column(name = "comment_count")
    @JsonProperty("comment_count")
    private Integer commentCount = 0;
    @Column(name = "create_time")
    @JsonProperty("create_time")
    private String createTime;
    @Column(name = "update_time")
    @JsonProperty("update_time")
    private String updateTime;

    @Column(name = "is_spider")
    @JsonProperty("is_spider")
    private Boolean isSpider;

    @Transient
    private V2Node node;
    @Transient
    private V2Member member;
    @Transient
    private List<V2Comment> comments;
    @Transient
    @JsonProperty("active_time")
    private String activeTime;

    public V2Post() {
    }

    public V2Post(String id, String type, String title, String url, Integer created, String memberId) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.url = url;
        this.created = created;
        this.memberId = memberId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getLastModified() {
        return lastModified;
    }

    public void setLastModified(Integer lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getLastTouched() {
        return lastTouched;
    }

    public void setLastTouched(Integer lastTouched) {
        this.lastTouched = lastTouched;
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

    public V2Node getNode() {
        return node;
    }

    public void setNode(V2Node node) {
        this.node = node;
    }

    public V2Member getMember() {
        return member;
    }

    public void setMember(V2Member member) {
        this.member = member;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSpider() {
        return isSpider;
    }

    public void setSpider(Boolean spider) {
        isSpider = spider;
    }

    public List<V2Comment> getComments() {
        return comments;
    }

    public void setComments(List<V2Comment> comments) {
        this.comments = comments;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    @Override
    public String toString() {
        return "V2Post{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", lastModified=" + lastModified +
                ", lastTouched=" + lastTouched +
                ", nodeId='" + nodeId + '\'' +
                ", isSpider=" + isSpider +
                ", memberId='" + memberId + '\'' +
                ", activeTime='" + activeTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", node=" + node +
                ", member=" + member +
                ", comments=" + comments +
                ", commentCount=" + commentCount +
                '}';
    }
}
