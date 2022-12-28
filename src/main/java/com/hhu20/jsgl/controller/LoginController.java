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
            //成功
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
        if((String)outMap.get("state")=="200"){

            String token = tokenUtil.createToken(userId);
            outMap.put("token",token);
            System.out.println(outMap.get("userName"));
            return outMap;
        }
        return outMap;
    }

}
