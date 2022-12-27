package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.entity.User;
import com.hhu20.jsgl.intermediate.LoginAndRegister;
import com.hhu20.jsgl.intermediate.UserMaintenance;
import com.hhu20.jsgl.pojo.Student;
import com.hhu20.jsgl.redis.RedisUtil;
import com.hhu20.jsgl.util.AuthorizationService;
import com.hhu20.jsgl.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Date;

@RestController
@RequestMapping(value="/users",method = {RequestMethod.POST,RequestMethod.GET})
public class LoginController {

    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    RedisUtil cache;
    @Autowired
    TokenUtil tokenUtil;

    @RequestMapping(value="userIdDuplication",method=RequestMethod.POST)
    public Map checkRegister(@RequestBody Map<String,Object> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        //debug print
        String userId = (String)inMap.get("userId");

        System.out.println(userId);

        if(LoginAndRegister.checkRegister(userId)){
            //存在 state = 4001
            outMap.put("state","4001");
        }else{
            //不存在 state = 200
            outMap.put("state","200");
        }
        return outMap;
    }

    @RequestMapping(value="reg",method=RequestMethod.POST)
    public Map Register(@RequestBody Map<String,Object> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        //debug print
        String userId = (String)inMap.get("userId");
        String password = (String)inMap.get("password");

        System.out.println(userId+" "+password);

        if(LoginAndRegister.checkRegister(userId)){
            //已经存在，失败 state = 4001
            outMap.put("state","4001");
        }
        if(LoginAndRegister.Register(userId, password)){

            outMap.put("state","200");
        }else {
            outMap.put("state", "4003");
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
        System.out.println(userId+" "+password);


//        if(!LoginAndRegister.checkRegister(userId)){
//            //用户不存在，失败 state = 4004
//            outMap = new TreeMap<>();
//            outMap.put("state","4004");
//            return outMap;
//        }

        outMap = LoginAndRegister.Login(userId, password);
        if((boolean)outMap.get("state")==true){

            String token = tokenUtil.createToken(userId);
            outMap.put("token",token);
            outMap.replace("state","200");
            return outMap;
        }
        outMap.replace("state","4005");
        return outMap;
    }

    @RequestMapping(value="test",method=RequestMethod.POST)
    public Map test(@RequestBody(required = false) Map<String,Object> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
//        for(String s : tokenMap.keySet()){
//            System.out.println(s);
//        }
//        String token = tokenMap.get("authorization");
//        System.out.println(token);
//        String userId = tokenUtil.verifyToken(token);
//        System.out.println(userId);
//        outMap.put("userId",userId);

//        System.out.println("start");
//        List<Student> studentList = UserMaintenance.getStuInfoById("a",true);
//
//        for (Student s: studentList){
//            System.out.println(s.getSNO());
//        }
//        System.out.println("end");
        return outMap;
    }
}
