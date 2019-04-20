package com.zhitu.workshop.springbootdemo.web;

import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.service.impl.UserServiceImpl;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
    public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    private JavaMailSender mailSender;
    static StringBuilder stringBuilder=new StringBuilder(4);

        //PhotoDao photoDao;
        //http://url/photo/photoid

    /**
     *查询用户是否存在
     * @param userName 用户名
     * @param model
     * @return 用户id
     */

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
        public Map<String,Object>doInsert(User user,ModelMap model,HttpServletRequest request,HttpServletResponse response, String A)throws Exception{
             Map<String,Object> result=new HashMap<String,Object>();
            if (!A.equals(stringBuilder.toString()))
            {
                result.put("code",1);
            }
            else
            {
                MessageDigest m=MessageDigest.getInstance("MD5");
                //System.out.println(oSMD5.getMD5ofStr("123"));
                m.update(user.getPassword().getBytes());
                byte resultData[] = m.digest();
                user.setPassword(new BigInteger(1, resultData).toString(16));
                 userServiceImpl.insertUser(user);
                result.put("code",0);
                result.put("userId",user.getUserId());
            }
            return result;

        }
    @RequestMapping(value = "/doLogin")
    @ResponseBody
    public Map<String,Object> login(User user,ModelMap model,HttpServletRequest request,HttpServletResponse response) throws NoSuchAlgorithmException {
        //后台非空验证
        MessageDigest m=MessageDigest.getInstance("MD5");
        //System.out.println(oSMD5.getMD5ofStr("123"));
        m.update(user.getPassword().getBytes());
        byte resultData[] = m.digest();
        Map<String,Object> result=new HashMap<String,Object>();
        String pwd = new BigInteger(1, resultData).toString(16);
        try
           {

               User user2 = userServiceImpl.selectUserByName(user.getUserName());
               if (!user2.getPassword().equals(pwd))
               {
                       result.put("code",1);//密码错误
               }
               else   //登录成功
               {
                   if(user2.getAuth().equals("1"))
                   {
                       result.put("code",3);
                       return result;
                   }
                   else {
                       result.put("code", 0);
                       request.getSession().setAttribute("ID", user2.getUserId());
                   }
               }
           }
           catch (Exception e)   //不存在这个帐号
           {
               result.put("code",2);
           }
           return result;
    }
    @RequestMapping(value = "/doCheck")
    @ResponseBody
    public Map<String,Object> validation(User user,ModelMap model,HttpServletRequest request,HttpServletResponse response) throws NoSuchAlgorithmException {
        Map<String,Object> result=new HashMap<String,Object>();
        try {
                User user2 = userServiceImpl.selectUserByName(user.getUserName());
                if (!user2.getUserName().equals(user.getUserName()) ) {
                    result.put("code", 1);  //用户名可以合法
                }
                else {
                    result.put("code", 2);  //用户名不合法
                }
        }
        catch (Exception e)
        {
            result.put("code", 1);
        }
        return result;
    }
    @RequestMapping(value = "/doSendMail")
    @ResponseBody
    public Map<String,Object> mail(User user,ModelMap model,HttpServletRequest request,HttpServletResponse response) throws NoSuchAlgorithmException {
        Map<String,Object> result=new HashMap<String,Object>();
        SimpleMailMessage message = new SimpleMailMessage();//创建简单邮件消息
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for(int i=0;i<4;i++)                                        //生成随机数
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            stringBuilder.append(ch);
        }
        String mail = user.getEmail();
        message.setFrom("1666938053@qq.com");//设置发送人
        message.setTo(mail);//设置收件人
        message.setSubject("测试");//设置主题
        message.setText("欢迎您注册星相册，您的验证码为"+stringBuilder);//设置内容
        mailSender.send(message);//执行发送邮件
        return result;
    }

    /*@ResponseBody
    public String photoDetail(@PathVariable Long photoId,
                              HttpServletRequest request, HttpServletResponse response) throws Exception {
        Photo photo = photoService.getPhoto(photoId);
        return photo.getPhotoName();
    }*/

}
