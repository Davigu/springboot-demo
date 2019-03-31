package com.zhitu.workshop.springbootdemo.web;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import com.zhitu.workshop.springbootdemo.bo.Photo;
import com.zhitu.workshop.springbootdemo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PhotoController {
    @Autowired
    PhotoService photoService;

    @RequestMapping(value = "/showAllPhoto",method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> showAllPhoto(HttpSession session, HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception{
        Map<String,Object> map=new HashMap<String,Object>();

        map.put("photos",photoService.showAllPhoto(Long.valueOf(String.valueOf(session.getAttribute("userID")))));
        return map;
    }

    @RequestMapping(value = "/findPhotoByID",method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> findPhotoByID(ModelMap model, HttpServletResponse response, HttpServletRequest request){
        Long id=4L;
        Map<String,Object> map=new HashMap<>();
        map.put("photo",photoService.findPhotoByID(id));
        return map;
    }

    @RequestMapping(value = "myPhoto")
    String myPhone(HttpServletRequest request,HttpServletResponse response){
        return "myShare";
    }
}
