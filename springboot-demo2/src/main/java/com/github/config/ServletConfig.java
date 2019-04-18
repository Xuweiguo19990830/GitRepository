package com.github.config;

import com.github.filter.HeFilter;
import com.github.servlet.HeServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * springboot没有xml配置文件，类名上方添加@Configuration注解可以表示这个类是一个spring的配置文件
 */
@Configuration
public class ServletConfig {
    /**
     * @Bean注解等价于<bean id="servletRegistrationBean" class="HeServlet的全路径名"></bean>
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        //将Servlet注入到Bean中
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HeServlet(), "/heServlet");
        return registrationBean;
    }

    /**
     * 等价于<bean id="filterRegistrationBean" class="HeFilter的全路径名"></bean>
     * @return
     */
    @Bean
    public FilterRegistrationBean heFilterRegistrationBean(){
        //将Filter注入到bean中
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new HeFilter());
        //添加filter拦截url
        registrationBean.addUrlPatterns("/heFilter");
        return registrationBean;
    }

    /**
     * 解决请求中文乱码问题，等价于web.xml中的:
     * <filter>
     *     <filter name = "characterEncodingFilter"></filter>
     *     <filter class = "CharacterEncodingFilter的全类名"></filter>
     * </filter>
     *
     * <filter-mapping>
     *     <filter name = "characterEncodingFilter"></filter>
     *     <init-param>
     *         <param-name>encoding</param-name>
     *         <param-value>UTF-8</param-value>
     *     </init-param>
     *     <url-prettern>/*</url-prettern>
     * </filter-mapping>
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //设置原先在web.xml中配置的字符编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        //设置过滤器拦截的路径
        registrationBean.addUrlPatterns("/*");
        return registrationBean;

    }
}
