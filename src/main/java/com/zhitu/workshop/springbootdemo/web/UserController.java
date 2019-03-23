package com.zhitu.workshop.springbootdemo.web;
import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
    public class UserController {

        @Autowired
        UserService  userService;

    /**
     * 登录页面的选择
     * @param userName 用户名
     * @return  和用户名对应的信息页面
     */
        @RequestMapping(value="/find/{userName}")
        public String login(@PathVariable String  userName, ModelMap model,
                            HttpServletRequest request, HttpServletResponse response)
        {
            User user= userService.selectUserByName(userName);
            model.put("user", user);
            return "select";

        }

    /**
     * 插入功能
     * @return 返回
     * @throws Exception
     */
        @RequestMapping(value = "/user/insert")
        public String insert(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            return "insert";
        }

    /**
     *  点击保存插入数据
     * @param user  用户信息
     * @return  把得到的信息传给前端
     * @throws Exception
     */
         @RequestMapping(value = "/user/doInsert")
         @ResponseBody
        public Map<String,Object> doInsert( User user, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            int count = userService.insertUser(user);
            Map<String,Object> result = new HashMap<>();
            result.put("code", 0);
            result.put("msg", "创建成功！");
            result.put("userId", user.getUserId());
            return result;
        }

    /*@ResponseBody
    public String photoDetail(@PathVariable Long photoId,
                              HttpServletRequest request, HttpServletResponse response) throws Exception {
        Photo photo = photoService.getPhoto(photoId);
        return photo.getPhotoName();
    }*/
}
