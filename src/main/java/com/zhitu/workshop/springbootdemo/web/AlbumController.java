package com.zhitu.workshop.springbootdemo.web;
import com.zhitu.workshop.springbootdemo.bo.Album;
import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.service.AlbumService;
import com.zhitu.workshop.springbootdemo.service.impl.AlbumServiceImpl;
import com.zhitu.workshop.springbootdemo.util.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        User user=LoginUser.getUser(request);
        request.setAttribute("list",albumServiceImpl.showAllAlbum(user.getUserId()));
        return "myAlbum";
    }

    @RequestMapping(value ="/showAll",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> showAllAlbum(ModelMap model, HttpServletRequest request, HttpServletResponse response)throws Exception {

        Map<String, Object> map = new HashMap<String,Object>();

        User user = LoginUser.getUser(request);

        if (user == null) {
            throw new Exception("用户未登录 ");
        }

        map.put("albums", albumService.showAllAlbum(user.getUserId()));
        return map;
    }



    @RequestMapping(value = "/editAlbum")
    @ResponseBody
    public String editAlbum(Album album,ModelMap model,HttpServletResponse response,HttpServletRequest request)throws Exception{

        return "成功";
    }
@RequestMapping(value="/deleteAlbum")
    @ResponseBody
public void deleteAlbum(@RequestParam(name = "albumId") Long albumId, HttpServletRequest request)
{
    try {
        albumServiceImpl.deleteAlbumById(albumId);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    @RequestMapping(value="/addAlbum")
    @ResponseBody
    public Map<String,Object >addAlbum(Album album,ModelMap model,HttpServletRequest request,HttpServletResponse response)
    {
        Map<String,Object> result=new HashMap<String,Object>();
        User user=LoginUser.getUser(request);
        Album a=new Album();
        a.setUserUseId(user.getUserId());
        a.setAlbum_Name(album.getAlbumName());
        a.setAlbumDescription(album.getAlbumDescription());
        albumServiceImpl.insertAlbum(a);
        result.put("code",0);
        result.put("albumName",album.getAlbumName());
        result.put("albumDescription",album.getAlbumDescription());
        result.put("use_user_id",user.getUserId());

        return result;
    }

    @RequestMapping(value="/getId")
    @ResponseBody
    public void getId(@RequestParam(name="userName") String a,HttpServletRequest request,HttpServletResponse response){

    }

}
