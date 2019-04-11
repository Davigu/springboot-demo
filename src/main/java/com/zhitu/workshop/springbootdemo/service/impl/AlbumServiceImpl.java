package com.zhitu.workshop.springbootdemo.service.impl;

import com.zhitu.workshop.springbootdemo.bo.Album;
import com.zhitu.workshop.springbootdemo.dao.AlbumDao;
import com.zhitu.workshop.springbootdemo.service.AlbumService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumDao albumDao;


    @Override
    public List<Album> showAllAlbum(long userID) throws Exception{

            List<Album> albums=albumDao.showAllAlbum(userID);
            return albums;
    }

    @Override
    public int deleteAlbumByID(long albumID,long userID) throws Exception{

            return albumDao.deleteAlbumByID(albumID,userID);


    }

    @Override
    public int updateAlbum(Album album) throws Exception{

            return albumDao.updateAlbum(album);

    }
}
