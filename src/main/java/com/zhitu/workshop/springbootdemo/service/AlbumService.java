package com.zhitu.workshop.springbootdemo.service;

import com.zhitu.workshop.springbootdemo.bo.Album;
import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.dao.AlbumDao;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AlbumService {
    /**
     * 显示所有相册，根据日期降序
     * @return list集合
     */
    List<Album> showAllAlbum(long userID) throws Exception;

    /**
     * 根据相册ID进行删除
     * @param albumID 相册ID
     * @return
     */
    int deleteAlbumByID(long albumID,long userID) throws Exception;

    /**
     * 更新相册信息
     * @param album
     * @return返回成功或失败
     */
    int updateAlbum(Album album) throws Exception;

    int insertAlbum(Album album) throws Exception;
}
