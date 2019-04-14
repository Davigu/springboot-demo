package com.zhitu.workshop.springbootdemo.dao;

import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecycleBinDao {
    /**
     * 移入回收站
     * @param re 回收照片信息
     * @return 返回影响行数
     */
    int delIntoRec(@Param("re")RecycleBin re);
}
