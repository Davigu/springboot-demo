package com.zhitu.workshop.springbootdemo.web;
import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

    @Controller
    public class UserController {

        @Autowired
        UserService  userService;
        //PhotoDao photoDao;
        //http://url/photo/photoid


        @RequestMapping(value="/find/{userName}")
        public String login(@PathVariable String  userName, ModelMap model,
                            HttpServletRequest request, HttpServletResponse response)
        {
            User user= userService.selectUserByName(userName);
            model.put("user", user);
            return "select";

        }

    /*@ResponseBody
    public String photoDetail(@PathVariable Long photoId,
                              HttpServletRequest request, HttpServletResponse response) throws Exception {
        Photo photo = photoService.getPhoto(photoId);
        return photo.getPhotoName();
    }*/
}
