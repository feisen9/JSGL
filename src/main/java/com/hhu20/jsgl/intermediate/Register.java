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
    public static boolean reg(String userId, String password){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            User user = new User();
            user.setUserId(userId);
            user.setPassword(password);
            UserDao userDao = new UserDao(sqlSession);
            List<Map> Stu = UserMaintenance.getStuInfoById(userId,false);
            List<Map> Tea = UserMaintenance.getTeaInfoById(userId,false);
            if(Stu.size()==Tea.size()){
                return false;
            }
            if(Stu.size()!=1 && Tea.size()!=1){
                return false;
            }
            String userType;
            String userName;
            if(Stu.size()==1){
                userType = "stu";
                userDao.add(userId,password,userType,userId);
                return true;
            }else if(Tea.size()==1){
                userType = "tea";
                userDao.add(userId,password,userType,userId);
                return true;
            }
            sqlSession.close();
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
