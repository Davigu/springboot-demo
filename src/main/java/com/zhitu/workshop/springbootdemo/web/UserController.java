package com.zhitu.workshop.springbootdemo.web;
import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
import com.sun.tools.javac.util.Convert;
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
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
    public class UserController {

        @Autowired
        UserService  userService;
        //PhotoDao photoDao;
        //http://url/photo/photoid

    /**
     *查询用户是否存在
     * @param userName 用户名
     * @param model
     * @return 用户id
     */
        @RequestMapping(value="/find")
        @ResponseBody
        public Long findByName(String userName, ModelMap model)
        {
            User user= userService.selectUserByName(userName);

            return user.getUserId();

        }

    /**
     *
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
        @RequestMapping(value = "/insert")
        public String insert(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            return "/insert";
        }
        @RequestMapping(value = "/home")
        public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
             return "/home";
        }


    /**
     *用户注册
     * @param user 用户类
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
        @RequestMapping(value = "/doInsert")
        @ResponseBody
        public Map<String,Object>doInsert(User user,ModelMap model,HttpServletRequest request,HttpServletResponse response)throws Exception{

            MessageDigest m=MessageDigest.getInstance("MD5");
            //System.out.println(oSMD5.getMD5ofStr("123"));
            m.update(user.getPassword().getBytes());
            byte resultData[] = m.digest();
            user.setPassword(resultData.toString());

            int count=userService.insertUser(user);

            Map<String,Object> result=new HashMap<String,Object>();

            result.put("code",0);
            result.put("userId",user.getUserId());

            return result;
        }

    /*@ResponseBody
    public String photoDetail(@PathVariable Long photoId,
                              HttpServletRequest request, HttpServletResponse response) throws Exception {
        Photo photo = photoService.getPhoto(photoId);
        return photo.getPhotoName();
    }*/
}
