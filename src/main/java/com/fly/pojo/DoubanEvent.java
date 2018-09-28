package com.fly.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fly.util.Util;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author david
 * @date 19/07/18 20:15
 */

@Entity
@Table(name = "douban_event")
@JsonIgnoreProperties({"status", "updatetTime", "createTime"})
public class DoubanEvent implements Serializable {

    @Id
    private String id;
    private String image;
    @Column(name = "adapt_url")
    @JsonProperty("adapt_url")
    private String adaptUrl;
    @Column(name = "loc_name")
    @JsonProperty("loc_name")
    private String locName;
    private String alt;
    private String label;
    private String category;
    private String title;
    @Column(name = "wisher_count")
    @JsonProperty("wisher_count")
    private Integer wisherCount;
    @Column(name = "has_ticket")
    @JsonProperty("has_ticket")
    private String hasTicket;
    private String content;
    @Column(name = "can_invite")
    @JsonProperty("can_invite")
    private String canInvite;
    @Column(name = "time_str")
    @JsonProperty("time_str")
    private String timeStr;
    private String album;
    @Column(name = "participant_count")
    @JsonProperty("participant_count")
    private String participantCount;
    private String tags;
    @Column(name = "image_hlrange")
    @JsonProperty("image_hlrange")
    private String imageHlrange;
    @Column(name = "begin_time")
    @JsonProperty("begin_time")
    private String beginTime;
    @Column(name = "end_time")
    @JsonProperty("end_time")
    private String endTime;
    @Column(name = "image_lmobile")
    @JsonProperty("image_lmobile")
    private String imageLmobile;
    @Column(name = "category_name")
    @JsonProperty("category_name")
    private String categoryName;
    @Column(name = "loc_id")
    @JsonProperty("loc_id")
    private String locId;
    private String url;
    private String uri;
    @Column(name = "fee_str")
    @JsonProperty("fee_str")
    private String feeStr;
    private String address;
    @Column(name = "price_range")
    @JsonProperty("price_range")
    private String priceRange;
    private String geo;
    private String status = "ACTIVE";
    @Column(name = "create_time")
    private String createTime = Util.getCurrentFormatTime();
    @Column(name = "update_time")
    private String updateTime = Util.getCurrentFormatTime();

    @Transient
    private DoubanUser owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAdaptUrl() {
        return adaptUrl;
    }

    public void setAdaptUrl(String adaptUrl) {
        this.adaptUrl = adaptUrl;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWisherCount() {
        return wisherCount;
    }

    public void setWisherCount(Integer wisherCount) {
        this.wisherCount = wisherCount;
    }

    public String getHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(String hasTicket) {
        this.hasTicket = hasTicket;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCanInvite() {
        return canInvite;
    }

    public void setCanInvite(String canInvite) {
        this.canInvite = canInvite;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(String participantCount) {
        this.participantCount = participantCount;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getImageHlrange() {
        return imageHlrange;
    }

    public void setImageHlrange(String imageHlrange) {
        this.imageHlrange = imageHlrange;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getImageLmobile() {
        return imageLmobile;
    }

    public void setImageLmobile(String imageLmobile) {
        this.imageLmobile = imageLmobile;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFeeStr() {
        return feeStr;
    }

    public void setFeeStr(String feeStr) {
        this.feeStr = feeStr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
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

    public DoubanUser getOwner() {
        return owner;
    }

    public void setOwner(DoubanUser owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "DoubanEventSpider{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", adaptUrl='" + adaptUrl + '\'' +
                ", locName='" + locName + '\'' +
                ", alt='" + alt + '\'' +
                ", label='" + label + '\'' +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", wisherCount=" + wisherCount +
                ", hasTicket='" + hasTicket + '\'' +
                ", content='" + content + '\'' +
                ", canInvite='" + canInvite + '\'' +
                ", timeStr='" + timeStr + '\'' +
                ", album='" + album + '\'' +
                ", participantCount='" + participantCount + '\'' +
                ", tags='" + tags + '\'' +
                ", imageHlrange='" + imageHlrange + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", imageLmobile='" + imageLmobile + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", locId='" + locId + '\'' +
                ", url='" + url + '\'' +
                ", uri='" + uri + '\'' +
                ", feeStr='" + feeStr + '\'' +
                ", address='" + address + '\'' +
                ", priceRange='" + priceRange + '\'' +
                ", geo='" + geo + '\'' +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
