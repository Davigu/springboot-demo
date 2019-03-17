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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
    public class UserController {

        @Autowired
        UserService  userService;
        @RequestMapping(value="/find/{userName}")
        public String register(@PathVariable String  userName, ModelMap model,
                            HttpServletRequest request, HttpServletResponse response)
        {
            User user= userService.selectUserByName(userName);
            model.put("user", user);
            return "select";
        }
        @RequestMapping(value = "/find/index")
        public String insert(ModelMap model,HttpServletResponse response,HttpServletRequest request)
        {
            return "index";
        }
        @RequestMapping(value = "/find/doInsert")
        @ResponseBody
        public Map<String,Object> doInsert(User user, ModelMap model, HttpServletRequest request, HttpServletResponse response)
        {
            int count = userService.insertUser(user);
            Map<String,Object> result=new HashMap<String, Object>();
            result.put("code",0);
            result.put("msg","创建成功");
            result.put("userName",user.getUserName());
            return result;
        }

}
