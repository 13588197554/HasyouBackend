package com.fly.pojo;//package com.com.fly.pojo;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import javax.persistence.*;
//
///**
// * @author david
// * @date 11/09/18 20:35
// */
//@Entity
//@Table(name = "douban_movie_short_comment")
//public class MovieShortComment {
//
//    @Id
//    private Integer id;
//    @Column(name = "useful_count")
//    @JsonProperty("useful_count")
//    private Integer usefulCount;
//    private String stars;
//    @Column(name = "movie_id")
//    @JsonProperty("movie_id")
//    private Integer movieId;
//    @Column(length = 4096)
//    private String content;
//    @Column(name = "created_at")
//    @JsonProperty("created_at")
//    private String createdAt;
//    @Column(name = "updateTime")
//    @JsonProperty("update_time")
//    private String updateTime;
//
//    @Transient
//    private DoubanUser author;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getUsefulCount() {
//        return usefulCount;
//    }
//
//    public void setUsefulCount(Integer usefulCount) {
//        this.usefulCount = usefulCount;
//    }
//
//    public String getStars() {
//        return stars;
//    }
//
//    public void setStars(String stars) {
//        this.stars = stars;
//    }
//
//    public Integer getMovieId() {
//        return movieId;
//    }
//
//    public void setMovieId(Integer movieId) {
//        this.movieId = movieId;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public DoubanUser getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(DoubanUser author) {
//        this.author = author;
//    }
//
//    public String getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(String updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "MovieShortComment{" +
//                "id=" + id +
//                ", usefulCount=" + usefulCount +
//                ", stars='" + stars + '\'' +
//                ", movieId=" + movieId +
//                ", content='" + content + '\'' +
//                ", createdAt='" + createdAt + '\'' +
//                ", author=" + author +
//                '}';
//    }
//}
