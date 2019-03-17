package com.zhitu.workshop.springbootdemo.dao;
import com.zhitu.workshop.springbootdemo.bo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Autowired
    UserDao userDao;

    @Override
    public User selectUserByName(String name) {

        return userDao.selectUserByName(name) ;
    }

    @Override
    public int insertUser(User user) {

        return userDao.insertUser(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
