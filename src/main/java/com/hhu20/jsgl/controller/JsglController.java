package com.hhu20.jsgl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@RestController
public class JsglController {
    @RequestMapping(value="users/login",method = RequestMethod.POST)
    public Map<String,Object> test(){
        Map<String,Object> outmap = new TreeMap<String,Object>();
        outmap.put("state",200);
        Map<String,String> data = new TreeMap<String,String>();
        data.put("userName","ADIM");
        data.put("userType","0");
        String k = UUID.randomUUID().toString();
        data.put("token", k);
        System.out.println(k);
        outmap.put("data",data);
        return outmap;
    }

    @RequestMapping(value="users/login",method= RequestMethod.GET)
    public Map<String,Object> test2(){
        Map<String,Object> outmap = new TreeMap<String,Object>();
        outmap.put("state",200);
        Map<String,String> data = new TreeMap<String,String>();
        data.put("userName","ADIM");
        data.put("userType","0");
        String k = UUID.randomUUID().toString();
        data.put("token", k);
        System.out.println(k);
        outmap.put("data",data);
        return outmap;
    }
}
