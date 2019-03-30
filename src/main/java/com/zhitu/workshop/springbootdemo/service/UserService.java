package com.zhitu.workshop.springbootdemo.service;


import com.zhitu.workshop.springbootdemo.bo.User;

import java.util.List;

public interface UserService {

    /**
     * 根据用户名选择查询用户信息
     * @param name    用户名
     * @return       查询到的user对象
     */

   User selectUserByName(String name);

    /**
     * 插入用户
     * @param user  用户信息
     * @return      返回值判断是否成功
     */

   int insertUser(User user);

    /**
     * 通过检索id来完成用户的信息删除
     * @param id 用户编号
     */
   void deleteUserById(Long id);

}
