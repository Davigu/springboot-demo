package com.zhitu.workshop.springbootdemo.bo;

public class Album {
    private Long albumId;
    private Long useUserId;
    private String albumName;
    private String theme;
    private String albumAuth;
    private String albumDescription;

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    private String albumAddress;

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getUseUserId() {
        return useUserId;
    }

    public void setUserUseId(Long userUserId) {
        this.useUserId = userUserId;
    }

    public String getAlbum_Name() {
        return albumName;
    }

    public void setAlbum_Name(String album_Name) {
        this.albumName = album_Name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAlbumAuth() {
        return albumAuth;
    }

    public void setAlbumAuth(String albumAuth) {
        this.albumAuth = albumAuth;
    }



    public String getAlbumAddress() {
        return albumAddress;
    }

    public void setAlbumAddress(String albumAddress) {
        this.albumAddress = albumAddress;
    }
}
