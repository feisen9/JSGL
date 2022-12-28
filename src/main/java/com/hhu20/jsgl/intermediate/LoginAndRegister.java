package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.SqlSessionTool;
import com.hhu20.jsgl.dao.StudentDao;
import com.hhu20.jsgl.dao.UserDao;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LoginAndRegister {

    public static List<Map> select(String userId){
        List<Map> user;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            UserDao userDao = new UserDao(sqlSession);
            user = userDao.select(userId);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static boolean add(String userId, String password, String userName, String userType){
        List<Map> user;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            UserDao userDao = new UserDao(sqlSession);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean checkRegister(String userId){
        /*
        调用数据库类
        如果数据库中有，返回true，否则返回false；
         */
        List<Map> user = select(userId);
        if (user.size()==1) return true;
        return false;
    }

    public static boolean Register(String userId, String password){
        /*
        调用数据库类
        如果插入成功，返回true，否则返回false；
         */
        int Stu = UserMaintenance.getStuInfoById(userId,false).size();
        int Tea = UserMaintenance.getTeaInfoById(userId,false).size();
        if(Stu==Tea){
            return false;
        }
        if(Stu!=1 && Tea!=1){
            return false;
        }
        String userType;
        if(Stu==1){
            userType = "stu";
        }else{
            userType = "tea";
        }

//        if () return true;
//        else return false;
        return false;
    }

    public static Map Login(String userId, String password){
        /*
        调用数据库类
        如果账户密码匹配，返回  state, userName，userType, state为ture；
        否则：返回state，state为false
         */
        /*
        实际代码
         */
        Map<String,Object> outMap = new TreeMap<>();

        List<Map> users = select(userId);
        if(users.size()!=1){
            outMap.put("state","4005");
            return outMap;
        }
        Map<String,Object> user = users.get(0);
        if((String)user.get("password")!=password){
            outMap.put("state","4005");
        }

        /*
        一下用于模拟
         */
        outMap.put("state","200");
        outMap.put("userName",user.get("username"));
        outMap.put("userType",user.get("usertype"));
        return outMap;
    }

}
