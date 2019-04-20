package com.zhitu.workshop.springbootdemo.dao;

import com.zhitu.workshop.springbootdemo.bo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserDao {
    /**
     * 根据用户名选择查询用户信息
     * @param name    用户名
     * @return       查询到的user对象
     */
    /**
     * 通过用户名查询
     * @param name 用户名
     * @return 用户类
     */
    User selectUserByName(@Param("name") String name);

    /**
     * 插入用户
     * @param user  用户信息
     * @return      返回值判断是否成功
     */
    int insertUser(@Param("user") User user);

    /**
     * 通过检索id来完成用户的信息删除
     * @param id
     */
    void deleteUserById(@Param("id") Long id);
    List<User> findAllUser(@Param("adminName") String adminName);

}
