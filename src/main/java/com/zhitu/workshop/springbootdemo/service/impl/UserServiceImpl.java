package com.zhitu.workshop.springbootdemo.service.impl;

import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    @Autowired
    UserService userService;
    /**
     * 根据用户名选择查询用户信息
     * @param name    用户名
     * @return       查询到的user对象
     */

   public User selectUserByName(String name)
    {
        return userService.selectUserByName(name);
    }

    /**
     * 插入用户
     * @param user  用户信息
     * @return      返回值判断是否成功
     */

   public  int insertUser(User user){
       return userService.insertUser(user);
   }



    /**
     * 通过检索id来完成用户的信息删除
     * @param id 用户编号
     */
   public void deleteUserById(Long id){

    }


}
