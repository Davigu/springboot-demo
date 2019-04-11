package com.zhitu.workshop.springbootdemo.bo;

import javax.xml.crypto.Data;
import java.util.Date;

public class Photo {
    private Long photoId;
    private Long albumId;
    private String photoName;
    private String photoDescription;
    private Date upTime;
    private Long love;
    private String state;
    private Long size;
    private Long lovenumber;
    private String phoAddress;

    public String getPhoAddress() {
        return phoAddress;
    }

    public void setPhoAddress(String photoAddress) {
        this.phoAddress = photoAddress;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Long getLove() {
        return love;
    }

    public void setLove(Long love) {
        this.love = love;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getLovenumber() {
        return lovenumber;
    }

    public void setLovenumber(Long lovenumber) {
        this.lovenumber = lovenumber;
    }
}
