package com.cyz.mygraduationproject.config;

import com.cyz.mygraduationproject.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有请求都被拦截，包括静态资源
                .excludePathPatterns("/stores","/registerData","/style/**","/","/register","/index","/login","/css/**","/font/**","/lay/**","/themes/**","/**.js","/js/**"); //放行的请求
    }
}
