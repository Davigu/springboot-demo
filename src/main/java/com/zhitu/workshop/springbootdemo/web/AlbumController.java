package com.zhitu.workshop.springbootdemo.web;
import com.zhitu.workshop.springbootdemo.bo.Album;
import com.zhitu.workshop.springbootdemo.service.AlbumService;
import com.zhitu.workshop.springbootdemo.service.impl.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AlbumController {

    @Autowired
    AlbumService albumService;
    @Autowired
    AlbumServiceImpl albumServiceImpl;
    @RequestMapping(value = "/myAlbum")
            public String showAlbum(HttpServletRequest request) throws Exception
    {
        request.setAttribute("list",albumServiceImpl.showAllAlbum(12));
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

    @RequestMapping(value="/addAlbum")
    @ResponseBody
    public Map<String,Object >addAlbum(Album album,ModelMap model,HttpServletRequest request,HttpServletResponse response)
    {
        Map<String,Object> result=new HashMap<String,Object>();
        albumServiceImpl.insertAlbum(album);
        result.put("code",0);
        return result;
    }

}
