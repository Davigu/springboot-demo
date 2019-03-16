package com.zhitu.workshop.springbootdemo.dao;

import com.zhitu.workshop.springbootdemo.bo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    User selectUserByName(@Param("name") String name);
    void insertUser(User user);
    List<User> findAll();
    void deleteUserById(Long id);
}
