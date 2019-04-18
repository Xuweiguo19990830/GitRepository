package com.github.controller;

import com.github.config.MyConfig;
import com.github.pojo.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//@Controller
@RestController //@RestController = @Controller + @ResponseBody,用于返回字符串或者是json数据
public class ConfigInfoController {

    /*@Value("${provider.name}")
    private String name;

    @Value("${provider.location}")
    private String location;*/

    @Resource
    private MyConfig myConfig;      //注入配置类

    @RequestMapping(value = "/configinfo")
    public String configInfo(){
        return "姓名为:"+ myConfig.getName() + ",位置为:" + myConfig.getLocation();
    }

    @RequestMapping(value = "/user1",method = RequestMethod.GET)     //只能以get请求方式进行访问
    public User getUser(){
        User user = new User();
        user.setName("徐唯国");
        user.setPassword("12345678");
        user.setAge(12);
        return user;
    }

    /**
     * GetMapping等价于@RequestMapping(value = "/user1",method = RequestMethod.GET)
     * @return
     */
    @GetMapping(value = "/user")
    public User getUser1(){
        User user = new User();
        user.setAge(19);
        user.setName("张三");
        user.setPassword("zhangsan123");
        return user;
    }

    /**
     * PostMapping等价于@RequestMapping(value = "/user2",method = RequestMethod.POST)
     * @return
     */
    @PostMapping(value = "/user")
    public User getUser2(){
        User user = new User();
        user.setAge(19);
        user.setName("李四");
        user.setPassword("lisi123");
        return user;
    }

    /**
     * PutMapping等价于@RequestMapping(value = "/user3",method = ReuqestMethod.PUT)
     * @return
     */
    @PutMapping(value = "/user")
    public User getUser3(){
        User user = new User();
        user.setAge(19);
        user.setName("小红");
        user.setPassword("xiaohong123");
        return user;
    }

    /**
     * DeleteMapping等价于@RequestMapping(value = "/user4",method = RequestMethod.DELETE)
     * @return
     */
    @DeleteMapping(value = "/user")
    public User getUser4(){
        User user = new User();
        user.setAge(19);
        user.setName("小王");
        user.setPassword("xiaowang123");
        return user;
    }
}
