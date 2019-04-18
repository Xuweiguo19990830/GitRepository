package com.github.controller;

import com.github.pojo.ItripUser;
import com.github.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;      //注入SpringBoot自动配置好的redisTemplate

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "/itripUser", method = RequestMethod.GET)
    public List<ItripUser> getItripUserList() {
        //查询缓存
        List<ItripUser> allUser = (List<ItripUser>) redisTemplate.opsForValue().get("allUser");
        //判断，如果缓存中有数据，直接将缓存中的数据返回给前台，否则，查询数据库
        if (allUser == null){
            //查询数据库
            List<ItripUser> userList = userService.getItripUserList();
            //如果查询结果不为空，将数据存到缓存中，并返回给前台
            if (userList != null) {
                redisTemplate.opsForValue().set("allUser",userList);
                return userList;
            }
        }
        System.out.println(allUser);
        return allUser;
    }


    /**
     * 更新用户
     * @param userName
     * @return
     */
    @RequestMapping(value = "/updateUser/{userName}", method = RequestMethod.GET)
    public String updateItripUser(@PathVariable String userName) {
        if (userName != null) {
            int result = userService.updateItripUser(userName);
            if (result > 0) {
                return "修改成功!";
            }
        }
        return "修改失败!";
    }
}
