package com.github.mapper;

import com.github.pojo.ItripUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<ItripUser> getItripUserList();

    int updateItripUser(@Param("userName") String userName);
}
