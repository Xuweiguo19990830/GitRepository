package com.github.config;

import com.github.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Configuration      //变为配置类
public class WebConfig extends WebMvcConfigurerAdapter {

    /*@Resource
    private LoginInterceptor loginInterceptor;*/

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册拦截器
        InterceptorRegistration interceptor = registry.addInterceptor(new LoginInterceptor());
        //指定好要拦截的路径,参数为字符串(可变参数)
        interceptor.addPathPatterns("/**");
        //指定好不拦截的路径,参数为字符串(可变参数)
        interceptor.excludePathPatterns("/user","/boot/**");
        super.addInterceptors(registry);

    }
}
