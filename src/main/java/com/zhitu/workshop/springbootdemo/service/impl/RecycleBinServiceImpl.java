package com.zhitu.workshop.springbootdemo.service.impl;

import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import com.zhitu.workshop.springbootdemo.dao.RecycleBinDao;
import com.zhitu.workshop.springbootdemo.service.RecycleBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecycleBinServiceImpl implements RecycleBinService {
    @Autowired
    RecycleBinDao recycleBinDao;

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
}
