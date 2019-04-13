package com.zhitu.workshop.springbootdemo.service;

import com.zhitu.workshop.springbootdemo.bo.Photo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {
    /**
     * 显示所有照片
     * @return 返回照片地址
     */
    List<Photo> showAllPhoto(Long userID);

    /**
     * 根据照片ID查询照片
     * @param ID
     * @return
     */
    Photo findPhotoByID(Long ID);

    Photo insertPhoto(Photo photo);
}
