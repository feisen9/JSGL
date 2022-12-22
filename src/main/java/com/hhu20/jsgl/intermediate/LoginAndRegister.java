package com.hhu20.jsgl.intermediate;

import java.util.Map;
import java.util.TreeMap;

public class LoginAndRegister {

    public static boolean checkRegister(String userId){
        /*
        调用数据库类
        如果数据库中有，返回true，否则返回false；
         */
//        if () return true;
//        else return false;
        return false;
    }

    public static boolean Register(String userId, String password){
        /*
        调用数据库类
        如果插入成功，返回true，否则返回false；
         */
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

        /*
        一下用于模拟
         */
        Map<String,Object> outMap = new TreeMap<>();
        outMap.put("state",true);
        outMap.put("userName","feisen");
        outMap.put("userType",0);
        return outMap;
    }

}
