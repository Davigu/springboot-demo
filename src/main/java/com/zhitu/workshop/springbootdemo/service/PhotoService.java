package com.zhitu.workshop.springbootdemo.service;

import com.zhitu.workshop.springbootdemo.bo.Photo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhotoService {
    /**
     * 显示所有照片
     * @return 返回照片地址
     */

    List<Photo> showAllPhoto(Long userID,int startRow) throws Exception;

    /**
     * 根据照片ID查询照片
     * @param photoID
     * @return
     */
    Photo findPhotoByID(Long photoID) throws Exception;

    /**
     * 根据用户id和相册id显示照片
     * @param userID 用户id
     * @param albumID 相册id
     * @return 照片列表
     */
    List<Photo> showByAlbum(Long userID,Long albumID) throws Exception;

    /**
     * 根据照片id删除照片
     * @param photoID 照片id
     * @return 返回是否成功
     * @throws Exception
     */
    boolean deletePhotoById(Long photoID) throws Exception;

    Photo insertPhoto(Photo photo);

    /**
     * 将照片移入回收站
     * @param photoID 传入照片
     * @return
     */
    int DelIntoRec(Long photoID)throws Exception;
}
