package com.github.service;

import com.github.mapper.UserMapper;
import com.github.pojo.ItripUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<ItripUser> getItripUserList() {
        return userMapper.getItripUserList();
    }

    @Override
    public int updateItripUser(String userName) {
        int result = 0;
        if (userName != null){
            result = userMapper.updateItripUser(userName);
        }
        return result;
    }

}
