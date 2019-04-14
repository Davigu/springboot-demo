package com.zhitu.workshop.springbootdemo.service;

import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import com.zhitu.workshop.springbootdemo.dao.RecycleBinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface RecycleBinService {


    int delIntoRec(RecycleBin re) throws Exception;

}
