package com.zhitu.workshop.springbootdemo.service;

import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User selectUserByName(String name) {
        return userDao.selectUserByName(name) ;
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
