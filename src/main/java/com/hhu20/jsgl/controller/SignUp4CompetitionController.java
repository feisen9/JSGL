package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;

@RestController
@RequestMapping(value="/teams",method={RequestMethod.PUT,RequestMethod.POST})
public class SignUp4CompetitionController {
    @Autowired
    TokenUtil tokenUtil;
    @RequestMapping(value="reg",method=RequestMethod.POST)
    public Map reg(@RequestBody Map<String,Object> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        Map<String, Object> data = (Map)inMap.get("data");
        String teamName = (String) data.get("teamName");
        String pno = (String) data.get("pno");
        List<Map> teamMembers = (List<Map>) data.get("teamMembers");
        List<Map> advisors = (List<Map>) data.get("advisors");

        /*
        缺少database支持
         */

        return outMap;
    }

    @RequestMapping(value="cancel",method=RequestMethod.POST)
    public Map cancel(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        String teamNo = inMap.get("teamNo");


        return outMap;
    }

    @RequestMapping(value="update",method=RequestMethod.PUT)
    public Map update(@RequestBody Map<String,Object> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        Map<String, Object> data = (Map)inMap.get("data");


        return outMap;
    }

    @RequestMapping(value="auditRegInfo",method=RequestMethod.POST)
    public Map auditRegInfo(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        String teamNo = inMap.get("teamNo");
        String regAuditResult = inMap.get("regAuditResult");


        return outMap;
    }

    @RequestMapping(value="getRegInfo",method=RequestMethod.POST)
    public Map getRegInfo(@RequestBody(required = false) Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }





        return outMap;
    }
}
