package com.zhitu.workshop.springbootdemo.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


public class LoginHandlerInterceptor implements HandlerInterceptor {

    //在目标方法执行之前运行此方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if( session.getAttribute("ID")!=null) {
            String loginUser = session.getAttribute("ID").toString();
            if (StringUtils.isEmpty(loginUser)) {
                //说明用户未登陆
                request.setAttribute("msg", "没有相应权限请先登陆");
                request.getRequestDispatcher("/home").forward(request, response);
                return false;
            }
        }
        else
        {
            request.getRequestDispatcher("/home").forward(request, response);
            return false;
        }
        return true;
    }
}