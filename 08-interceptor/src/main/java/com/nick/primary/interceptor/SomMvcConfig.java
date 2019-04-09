package com.nick.primary.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SomMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    SomeInterceptor someInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(someInterceptor)
                .addPathPatterns("/first/**")
                .excludePathPatterns("/second/**");
    }
}
