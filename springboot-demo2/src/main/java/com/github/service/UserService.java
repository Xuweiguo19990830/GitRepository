package com.github.service;

import com.github.pojo.ItripUser;

import java.util.List;

public interface UserService {
    List<ItripUser> getItripUserList();

    int updateItripUser(String userName);
}
