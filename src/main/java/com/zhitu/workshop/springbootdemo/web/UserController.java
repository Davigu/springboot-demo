package com.zhitu.workshop.springbootdemo.web;

import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/findByName")
    public @ResponseBody
    User findByName(String name) throws Exception{
        User user = userDao.selectUserByName(name);
        System.out.println(user);
        return  user;
    }
    @RequestMapping(value = "/all")
    public @ResponseBody
    List<User> all() throws Exception{
        List<User> user = userDao.findAll();
        System.out.println(user);
        return  user;
    }
    @RequestMapping(value = "/insert")
    public @ResponseBody String insertUser(String id,String name,String email) throws Exception{
        userDao.insertUser(Integer.parseInt(id),name,email);

        System.out.println(id+name+email);
        return  "saved";
    }
}
