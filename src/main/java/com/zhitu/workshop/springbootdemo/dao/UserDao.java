package com.zhitu.workshop.springbootdemo.dao;

import com.zhitu.workshop.springbootdemo.bo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserDao {
    /**
     * 通过用户名查询
     * @param name 用户名
     * @return 用户类
     */
    User selectUserByName(@Param("name") String name);

    /**
     *增加用户信息
     * @param user用户类
     * @return数据库更新行数
     */
    int insertUser(@Param("user") User user);

    /**
     * 查询所有用户
     * @return list集合
     */
    List<User> findAll();

    /**
     * 根据id删除用户
     * @param id 用户id
     */
    void deleteUserById(Long id);
}
