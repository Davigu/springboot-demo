package com.zhitu.workshop.springbootdemo.service;

import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import com.zhitu.workshop.springbootdemo.dao.RecycleBinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface RecycleBinService {


    int delIntoRec(RecycleBin re) throws Exception;

    List<RecycleBin> showFiles(Long userID) throws Exception;

    boolean RecPhoto(Long fileID,Long photoID)throws Exception;

    boolean DelPhotoComp(Long fileID,Long photoID)throws Exception;

    List<RecycleBin> getAllFile(Date date)throws Exception;
}
