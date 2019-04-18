package com.github.springbootdemo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot项目的启动类
 */

@ComponentScans({@ComponentScan(value = "com.github.controller"),
                 @ComponentScan(value = "com.github.interceptor"),
                @ComponentScan(value = "com.github.config"),
                @ComponentScan(value = "com.github.service"),
                @ComponentScan(value = "com.github.pojo")})        //扫描Component类(如果启动类和Component类不再同一个包下，使用该注解)
@MapperScan(value = "com.github.mapper")                            //因为mapper层没有配置注解,配置mapper扫描包
//配置Servlet注解扫描,配置Servlet和Filter所在的包
@ServletComponentScan(basePackages = {"com.github.servlet","com.github.filter"})
@EnableTransactionManagement                                        //启动SpringBoot事务支持
@SpringBootApplication
public class SpringbootDemo2Application {

    //启动了SpringBoot程序，启动SpringBoot容器，加载内嵌的tomcat服务器
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo2Application.class, args);
    }

}
