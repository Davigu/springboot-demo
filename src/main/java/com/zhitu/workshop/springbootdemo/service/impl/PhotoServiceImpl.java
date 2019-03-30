package com.zhitu.workshop.springbootdemo.service.serviceImpl;

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
    public List<Photo> showAllPhoto(Long userID) {
        return photoDao.showAllPhoto(userID);
    }

    @Override
    public Photo findPhotoByID(Long ID) {
        return photoDao.findPhotoByID(ID);
    }
}
