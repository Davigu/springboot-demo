package com.zhitu.workshop.springbootdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ShareController {
    @RequestMapping(value = "/share")
    public String showShare()
    {
        return"myShare";
    }
}
