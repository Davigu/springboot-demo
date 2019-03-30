package com.zhitu.workshop.springbootdemo.service;

import com.zhitu.workshop.springbootdemo.dao.AlbumDao;

import java.util.List;

public interface AlbumService {
    List<AlbumDao> showAll();
    List<AlbumDao> findByName(String albumName);
}
