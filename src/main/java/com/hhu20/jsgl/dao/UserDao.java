package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.TeacherMapper;
import com.hhu20.jsgl.mapper.UserMapper;
import com.hhu20.jsgl.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class UserDao {
    private SqlSession sqlSession;
    private UserMapper userMapper;
    public UserDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    public List<Map> selectAll(){
        return userMapper.selectAll();
    }

    public void updatePassword (String userid,String password) throws Exception{
        userMapper.updatePassword(userid,password);
    }

    public void deleteOne (String userId) throws Exception{
        userMapper.deleteOne(userId);
    }

}
