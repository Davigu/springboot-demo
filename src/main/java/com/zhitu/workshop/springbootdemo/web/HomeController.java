package com.zhitu.workshop.springbootdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        // 设置jsp的模板文件
        ModelAndView modelAndView = new ModelAndView("/index"); //设置对应JSP的模板文件
        modelAndView.addObject("hi", "Hello,Cat"); //设置${hi}标签的值为Hello,Cat
        return modelAndView;
    }
}
