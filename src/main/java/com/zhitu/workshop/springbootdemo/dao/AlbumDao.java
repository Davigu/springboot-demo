package com.zhitu.workshop.springbootdemo.dao;
import com.zhitu.workshop.springbootdemo.bo.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {
    Album selectAlbumByName(@Param("name") String name);
    int insertAlbum(@Param("album") Album album);
    List<Album> findAll();
    void deleteAlbumById();
}
