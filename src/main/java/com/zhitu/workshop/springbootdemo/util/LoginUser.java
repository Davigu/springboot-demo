package com.zhitu.workshop.springbootdemo.util;

import com.zhitu.workshop.springbootdemo.bo.User;

import javax.servlet.http.HttpServletRequest;

public class LoginUser {
    public static final String USER_SESSION_KEY="USER";

    public static User getUser(HttpServletRequest request) {
        return (User)request.getSession().getAttribute(USER_SESSION_KEY);
    }

    public static void setUser(HttpServletRequest request, User usr) {
        request.getSession().setAttribute(USER_SESSION_KEY, usr);
    }
}
