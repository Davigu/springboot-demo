package com.zhitu.workshop.springbootdemo.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlbumDao {
    /**
     * 显示所有相册，根据日期降序
     * @return list集合
     */
    List<AlbumDao> showAll();

    /**
     * 根据相册名称模糊查询
     * @param albumName 相册名
     * @return Album的集合
     */
    List<AlbumDao> findByName(String albumName);


}
