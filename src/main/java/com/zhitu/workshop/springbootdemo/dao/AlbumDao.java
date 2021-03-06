package com.zhitu.workshop.springbootdemo.dao;

import com.zhitu.workshop.springbootdemo.bo.Album;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface AlbumDao {
    /**
     * 显示所有相册，根据日期降序
     * @return list集合
     */
    List<Album> showAllAlbum(@Param("userID") Long userID);

    /**
     * 根据相册ID进行删除
     * @param
     * @return
     */
    int deleteAlbumById(@Param("albumId")Long AlbumId);

    /**
     * 更新相册信息
     * @param album
     * @return返回成功或失败
     */
    int updateAlbum(@Param("album") Album album);

    /**
     *
     * @param album
     * @return
     */
     int insertAlbum(@Param("album") Album album);

    public Long getId(@RequestParam(name="userName") String a);
}
