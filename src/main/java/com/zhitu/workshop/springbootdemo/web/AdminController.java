package com.zhitu.workshop.springbootdemo.web;

import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @RequestMapping(value = "/admin")
    public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response,String name) throws Exception {

        List<User> list = userServiceImpl.findAllUser(name);
        request.setAttribute("list",list);
        return "/admin";
    }
    @RequestMapping(value ="/showAll")
    @ResponseBody
    public Map <String,Object> showAllUser(ModelMap model, HttpServletRequest request, HttpServletResponse response,String name)throws Exception {

        Map<String,Object> result=new HashMap<String,Object>();
        List<User> list = userServiceImpl.findAllUser(name);
        request.setAttribute("list",list);
        return result;
    }
}
