package com.zhitu.workshop.springbootdemo.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhitu.workshop.springbootdemo.util.LoginUser;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


public class LoginHandlerInterceptor implements HandlerInterceptor {

    //在目标方法执行之前运行此方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if( LoginUser.getUser(request)==null) {

            //request.getRequestDispatcher("/home").forward(request, response);
            response.sendRedirect("/home");
            return false;
        }
        return true;
    }
}