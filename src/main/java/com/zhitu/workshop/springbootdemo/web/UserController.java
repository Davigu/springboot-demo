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

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.Color;

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
    public Map<String,Object> login(User user,ModelMap model,HttpServletRequest request,HttpServletResponse response,String C) throws NoSuchAlgorithmException {
        //后台非空验证
        MessageDigest m=MessageDigest.getInstance("MD5");
        //System.out.println(oSMD5.getMD5ofStr("123"));
        m.update(user.getPassword().getBytes());
        byte resultData[] = m.digest();
        Map<String,Object> result=new HashMap<String,Object>();
        String pwd = new BigInteger(1, resultData).toString(16);
        String str=request.getSession().getAttribute("strCode").toString();
        if(!str.equals(C))
        {
            result.put("code",4);
            return result;
        }
        try
           {

               User user2 = userServiceImpl.selectUserByName(user.getUserName());
               if (!user2.getPassword().equals(pwd))
               {
                       result.put("code",1);//密码错误
               }
               else   //登录成功
               {
                   if(user2.getAuth()!=null&&user2.getAuth().equals("1"))          //登录为管理员
                   {
                       result.put("code",3);
                       request.getSession().setAttribute("ID", user2.getUserId());
                       return result;
                   }
                   else {
                       result.put("code", 0);
                       request.getSession().setAttribute("ID", user2.getUserId());
                       return result;
                   }
               }
           }
           catch (Exception e)   //不存在这个帐号
           {
               result.put("code",2);
           }
           return result;
    }
    @RequestMapping({"authCode"})
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response,HttpSession session)
            throws IOException {
        int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<40;i++){
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String strCode = "";
        for(int i=0;i<4;i++){
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
        //将字符保存到session中用于前端的验证
        session.setAttribute("strCode", strCode);
        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();

    }
    //创建颜色
    Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255)
            fc = 255;
        if(bc>255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
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
