package com.zhitu.workshop.springbootdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class RecycleBinController {

    @RequestMapping(value = "/recyclebin")
    public String showRecyclebin()
    {
        return "myRecycleBin";
    }
}
