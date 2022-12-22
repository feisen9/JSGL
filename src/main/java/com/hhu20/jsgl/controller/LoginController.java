package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.intermediate.LoginAndRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/users",method = {RequestMethod.POST,RequestMethod.GET})
public class LoginController {

    @RequestMapping(value="userIdDuplication",method=RequestMethod.POST)
    public Map checkRegister(String userId){
        Map<String, Object> outMap = new TreeMap<>();
        //debug print
        System.out.println(userId);

        if(LoginAndRegister.checkRegister(userId)){
            //存在 state = 4001
            outMap.put("state",4001);
        }else{
            //不存在 state = 200
            outMap.put("state",200);
        }
        return outMap;
    }

    @RequestMapping(value="reg",method=RequestMethod.POST)
    public Map Register(String userId,String password){
        Map<String, Object> outMap = new TreeMap<>();
        //debug print
        System.out.println(userId+" "+password);

        if(LoginAndRegister.checkRegister(userId)){
            //已经存在，失败 state = 4001
            outMap.put("state",4001);
        }
        if(LoginAndRegister.Register(userId, password)){
            outMap.put("state",200);
        }else {
            outMap.put("state", 4003);
        }
        return outMap;
    }

    @RequestMapping(value="login",method=RequestMethod.POST)
    public Map Login(@RequestBody Map<String,Object> inMap){
        Map<String, Object> outMap;
        //debug print
        String userId="test1", password= "test2";
        userId = (String) inMap.get("userId");
        password = (String) inMap.get("password");

//        System.out.println(inMap.size());
//        System.out.println("遍历map中的值");
//        for (Object key : inMap.keySet()) {
//            System.out.println("value = " + key);
//        }
//        for (Object value : inMap.values()) {
//            System.out.println("value = " + value);
//        }
        System.out.println(userId+" "+password);

        if(!LoginAndRegister.checkRegister(userId)){
            //用户不存在，失败 state = 4004
            outMap = new TreeMap<>();
            outMap.put("state",4004);
            return outMap;
        }

        outMap = LoginAndRegister.Login(userId, password);
        if((boolean)outMap.get("state")==true){
            outMap.replace("state",200);
            return outMap;
        }
        outMap.replace("state",4005);
        return outMap;
    }
}
