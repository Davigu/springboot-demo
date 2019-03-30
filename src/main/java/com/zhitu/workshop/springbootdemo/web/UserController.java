package com.zhitu.workshop.springbootdemo.web;

import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;

import java.security.MessageDigest;

import java.util.Map;

@Controller
    public class UserController {

        @Autowired
    UserServiceImpl userServiceImpl;




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
        public Long findByName(String userName, ModelMap model,
                               HttpServletRequest request, HttpServletResponse response){
            User user= userServiceImpl.selectUserByName(userName);
            return user.getUserId();
        }
    /**
     * 插入功能
     * @return 返回
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
     *  点击保存插入数据
     * @param user  用户信息
     * @return  把得到的信息传给前端
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
            int count= userServiceImpl.insertUser(user);
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
