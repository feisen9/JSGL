package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> selectByCondition(User user);
    List<User> selectUserId(String userId);
    List<User> selectAll();

}
