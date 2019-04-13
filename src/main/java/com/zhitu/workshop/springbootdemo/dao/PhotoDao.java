package com.zhitu.workshop.springbootdemo.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zhitu.workshop.springbootdemo.bo.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhotoDao {

    /**
     * 显示所有照片
     * @return 返回照片地址
     */
    List<Photo> showAllPhoto(@Param("userID") long userID);

    /**
     * 根据照片ID查询照片
     * @param
     * @return 返回照片对象
     */
    Photo findPhotoByID(@Param("photoID") long photoID);

    int insertPhoto(@Param("photo")Photo photo);
}
