package com.zhitu.workshop.springbootdemo.service.impl;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zhitu.workshop.springbootdemo.bo.Photo;
import com.zhitu.workshop.springbootdemo.dao.PhotoDao;
import com.zhitu.workshop.springbootdemo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoDao photoDao;
    @Override
    public List<Photo> showAllPhoto(Long userID,int startRow) throws Exception{
        if(userID==null){
            throw new Exception("用户id为空");
        }else {
            return photoDao.showAllPhoto(userID,startRow);
        }

    }

    @Override
    public Photo findPhotoByID(Long photoID) throws Exception{
        if(photoID==null){
            throw new Exception("照片id为空");
        }else {
            return photoDao.findPhotoByID(photoID);
        }

    }

    @Override
    public List<Photo> showByAlbum(Long userID, Long albumID) throws Exception{
        if(userID==null){
            throw new Exception("用户id空");
        }else if(albumID==null) {
            throw new Exception("相册id为空");
        }else{
            return photoDao.showByAlbum(userID,albumID);
        }
    }

    @Override
    public boolean deletePhotoById(Long photoID) throws Exception {
        if(photoID==null){
            throw new Exception("照片id为空");
        }else {
            if(photoDao.deletePhotoById(photoID)>0){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public Photo insertPhoto(Photo photo){
        int count =photoDao.insertPhoto(photo);
        return photo;
    }

    @Override
    public int DelIntoRec(Long photoID) throws Exception {
        int count =photoDao.delIntoRec(photoID);
        if(count==0){
            throw new Exception("移入回收站失败");
        }else{
            return count;
        }
        //return 0;
    }

    @Override
    public double calSpace(Long userId) throws Exception {
        double count=0;
        List<Photo> photos=photoDao.getAblePhoto(userId);
        for(Photo p:photos){
            count+=p.getSize()/(1024*1024);
        }
        return count/10240;
    }

}
