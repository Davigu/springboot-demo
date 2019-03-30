package com.zhitu.workshop.springbootdemo.service.impl;

import com.zhitu.workshop.springbootdemo.bo.Album;
import com.zhitu.workshop.springbootdemo.dao.AlbumDao;
import com.zhitu.workshop.springbootdemo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumDao albumDao;

    @Override
    public List<AlbumDao> showAll() {
        return albumDao.showAll();
    }

    @Override
    public List<AlbumDao> findByName(String albumName) {
        return albumDao.findByName(albumName);
    }
}
