package com.zhitu.workshop.springbootdemo.web;

import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/find/{userName}")
    public String login(@PathVariable String  userName, ModelMap model,
                        HttpServletRequest request, HttpServletResponse response)
    {
        User user= userService.selectUserByName(userName);
        model.put("user", user);
        return "login";
    }
}
