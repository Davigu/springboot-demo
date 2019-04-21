package com.zhitu.workshop.springbootdemo.service.impl;

import com.zhitu.workshop.springbootdemo.bo.Photo;
import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import com.zhitu.workshop.springbootdemo.dao.PhotoDao;
import com.zhitu.workshop.springbootdemo.dao.RecycleBinDao;
import com.zhitu.workshop.springbootdemo.service.RecycleBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecycleBinServiceImpl implements RecycleBinService {
    @Autowired
    RecycleBinDao recycleBinDao;
    @Autowired
    PhotoDao photoDao;

    @Override
    public int delIntoRec(RecycleBin re) throws Exception{
        try{
            int count=recycleBinDao.delIntoRec(re);
            return count;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;

    }

    @Override
    public List<RecycleBin> showFiles(Long userID) throws Exception {
        try{
            return recycleBinDao.showFiles(userID);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean RecPhoto(Long fileID,Long photoID) throws Exception {
        try
        {
            int count1=photoDao.recoverPhoto(photoID);
            int count2=recycleBinDao.delPhoto(fileID);
            if(count1>0&&count2>0){
                return true;
            }else {
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean DelPhotoComp(Long fileID, Long photoID) throws Exception {
        try{
            int count1=photoDao.deletePhotoById(photoID);
            int count2=recycleBinDao.delPhoto(fileID);
            if(count1>0&&count2>0){
                return true;
            }else{
                return false;
            }

        }catch(Exception e){
            return false;
        }

    }

    @Override
    public List<RecycleBin> getAllFile(Date date) throws Exception {
        try{
            return recycleBinDao.getAllFile(date);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
