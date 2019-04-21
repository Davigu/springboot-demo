package com.zhitu.workshop.springbootdemo.web;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
/**
 * 扩展SpringMVC
 * SpringBoot2使用的Spring5，因此将WebMvcConfigurerAdapter改为WebMvcConfigurer
 * 使用WebMvcConfigurer扩展SpringMVC好处既保留了SpringBoot的自动配置，又能用到我们自己的配置
 */
//@EnableWebMvc //如果我们需要全面接管SpringBoot中的SpringMVC配置则开启此注解，
//开启后，SpringMVC的自动配置将会失效。
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //如果没有数据返回到页面，没有必要用控制器方法对请求进行映射
        registry.addViewController("/").setViewName("home");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //SpringMVC下，拦截器的注册需要排除对静态资源的拦截(*.css,*.js)
        //SpringBoot已经做好了静态资源的映射，因此我们无需任何操作
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/home","/","/service/**","/authCode","/doInsert","/doLogin","/js/**","/css/**","/picture/**","/images/**","/fonts/**");
    }
}