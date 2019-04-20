package com.zhitu.workshop.springbootdemo.service.impl;
import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.dao.UserDao;
import jdk.nashorn.internal.ir.annotations.Ignore;
import com.zhitu.workshop.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;
    /**
     * 根据用户名选择查询用户信息
     * @param name    用户名
     * @return       查询到的user对象
     */
    @Override
    public User selectUserByName(String name) {
        return userDao.selectUserByName(name) ;
    }

    /**
     * 插入用户
     * @param user  用户信息
     * @return      返回值判断是否成功
     */
    @Override
    public int insertUser(User user) {

        return userDao.insertUser(user);
    }
    @Override
    public List <User> findAllUser(String adminName) throws Exception
    {
        List<User> userList = userDao.findAllUser(adminName);
        return userList;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
