package com.zhitu.workshop.springbootdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

    @RequestMapping(value = "/admin")
    public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/admin";
    }
}
