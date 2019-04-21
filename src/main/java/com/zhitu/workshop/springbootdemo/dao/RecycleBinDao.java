package com.zhitu.workshop.springbootdemo.dao;

import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface RecycleBinDao {
    /**
     * 移入回收站
     * @param re 回收照片信息
     * @return 返回是否成功
     */
    int delIntoRec(@Param("re")RecycleBin re);

    /**
     * 显示回收站中的文件
     * @param userID 用户id
     * @return 回收站中list列表
     */
    List<RecycleBin> showFiles(@Param("userID")long userID);

    /**
     * 从回收站中删除
     * @param fileID
     * @return
     */
    int delPhoto(@Param("fileID")Long fileID);

    List<RecycleBin> getAllFile(@Param("now") Date now);

}
