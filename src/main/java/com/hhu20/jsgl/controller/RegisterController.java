package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.intermediate.LoginAndRegister;
import com.hhu20.jsgl.intermediate.Register;
import com.hhu20.jsgl.redis.RedisUtil;
import com.hhu20.jsgl.util.AuthorizationService;
import com.hhu20.jsgl.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;
@RestController
@RequestMapping(value="/users",method = {RequestMethod.POST,RequestMethod.GET})

public class RegisterController {

        @Autowired
        AuthorizationService authorizationService;

        @Autowired
        RedisUtil cache;
        @Autowired
        TokenUtil tokenUtil;
    @RequestMapping(value="reg",method= RequestMethod.POST)
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

        String usertype = Register.reg(userId, password);
        System.out.println("usertype:"+usertype);
        if(usertype.equals("stu") || usertype.equals("tea"))
            outMap.put("state","200");
        else
            outMap.put("state","4003");
        return outMap;
    }

}
