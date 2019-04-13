package com.zhitu.workshop.springbootdemo.web;

import com.zhitu.workshop.springbootdemo.bo.Album;
import com.zhitu.workshop.springbootdemo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @RequestMapping(value = "myAlbum") public String showAlbum(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception
    {
        Long ID;
        //        if(request.getSession().getAttribute("userID")==null){
//            throw new Exception("session中用户id为空");
//        }else{
//            userID=(Long)request.getSession().getAttribute("userID");
//        }
        List<Album> list=albumService.showAllAlbum(Long.valueOf("12"));

        return "myAlbum";
    }
}
