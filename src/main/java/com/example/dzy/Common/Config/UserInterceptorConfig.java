package com.example.dzy.Common.Config;

import com.example.dzy.Common.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserInterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求  登录注册除外
        registry.addInterceptor(JwtInterceptor()).addPathPatterns("/user/data")
                .excludePathPatterns("/user/login","/user/register","/admin/login");
    }

    @Bean
    public JwtInterceptor JwtInterceptor(){
        return new JwtInterceptor();
    }
}
