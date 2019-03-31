package com.zhitu.workshop.springbootdemo.web;

import com.zhitu.workshop.springbootdemo.bo.Album;
import com.zhitu.workshop.springbootdemo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/album")
            public String showAlbum()
    {
        return "myAlbum";
    }



    @RequestMapping(value ="/showAll",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> showAllAlbum(ModelMap model, HttpServletRequest request, HttpServletResponse response)throws Exception {

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("albums", albumService.showAllAlbum(14));
        return map;
    }

    @RequestMapping(value = "/editAlbum")
    @ResponseBody
    public String editAlbum(Album album,ModelMap model,HttpServletResponse response,HttpServletRequest request)throws Exception{


        int count=albumService.deleteAlbumByID(Long.valueOf(1),Long.valueOf(14));
        return "成功";
    }

}
