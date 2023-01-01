package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.BonusRuleDao;
import com.hhu20.jsgl.dao.SqlSessionTool;
import com.hhu20.jsgl.dao.UserDao;
import com.hhu20.jsgl.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Register {
    public static String reg(String userId, String password){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            User user = new User();
            user.setUserId(userId);
            user.setPassword(password);
            UserDao userDao = new UserDao(sqlSession);
            userDao.add(user);
            String usertype = user.getUserType();
            sqlSession.close();
            return usertype;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
