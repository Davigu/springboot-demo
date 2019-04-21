package com.zhitu.workshop.springbootdemo.util;

import com.zhitu.workshop.springbootdemo.bo.Album;
import javax.servlet.http.HttpServletRequest;

public class OpenAlbum {
    public static final String ALBUM_SESSION="ALBUM";
    public static Album getAlbum(HttpServletRequest request) {
        return (Album)request.getSession().getAttribute(ALBUM_SESSION);
    }

    public static void setAlbum(HttpServletRequest request, Album album) {
        request.getSession().setAttribute(ALBUM_SESSION, album);
    }
}
