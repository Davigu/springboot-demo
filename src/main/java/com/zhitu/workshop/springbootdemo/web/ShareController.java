package com.zhitu.workshop.springbootdemo.web;

import org.springframework.web.bind.annotation.RequestMapping;

public class ShareController {
    @RequestMapping(value = "/share")
    public String showShare()
    {
        return"myShare";
    }
}
