package com.zhitu.workshop.springbootdemo.dao;

import com.zhitu.workshop.springbootdemo.bo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    User selectUserByName(@Param("name")String name)throws Exception;
    User insertUser(@Param("id")Integer id,@Param("name")String name,@Param("email")String email)throws Exception;
    List<User> findAll()throws Exception;
}
