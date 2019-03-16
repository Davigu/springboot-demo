package com.zhitu.workshop.springbootdemo.service;


import com.zhitu.workshop.springbootdemo.bo.User;

import java.util.List;

public interface UserService {
   User selectUserByName(String name);
    void insertUser(User user);
    List<User> findAll();
    void deleteUserById(Long id);

}
