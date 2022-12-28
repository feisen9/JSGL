package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//    List<Map> selectByCondition(User user);
    List<Map> selectUserId(String userId);
    List<Map> selectAll();
    void updatePassword(@Param("userId") String userid, @Param("password") String password);
    void deleteOne(@Param("userId") String userId);

    List<Map> select(String userId);

}
