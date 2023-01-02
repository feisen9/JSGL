package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.intermediate.Award;
import com.hhu20.jsgl.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/awards",method={RequestMethod.PUT,RequestMethod.POST})
public class CompetitionAwardsController {
    @Autowired
    TokenUtil tokenUtil;
    @RequestMapping(value="add",method=RequestMethod.POST)
    public Map add(@RequestBody Map<String,Object> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        Map<String,Object> data = (Map)inMap.get("data");
        int teamNo = (int) data.get("teamNo");
        int pno = (int) data.get("pno");
        List<Map> teamMembers = (List<Map>) data.get("teamMembers");
        List<Map> advisors = (List<Map>) data.get("advisors");
        String awardInfo = (String) data.get("awardInfo");


        int rows = Award.add(teamNo,teamMembers,advisors,pno,awardInfo);
        if(rows == 1)
            outMap.put("state","200");
        else
            outMap.put("state","4003");
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

        Map<String,Object> data = (Map)inMap.get("data");
        int teamNo = (int) data.get("teamNo");
        int pno = (int) data.get("pno");
        List<Map> teamMembers = (List<Map>) data.get("teamMembers");
        List<Map> advisors = (List<Map>) data.get("advisors");
        String awardInfo = (String) data.get("awardInfo");
        int rows = Award.update(teamNo,teamMembers,advisors,pno,awardInfo);
        if(rows == 1)
            outMap.put("state","200");
        else
            outMap.put("state","4004");
        return outMap;
    }

    @RequestMapping(value="auditAwardInfo",method=RequestMethod.POST)
    public Map auditAwardInfo(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String teamNo = inMap.get("teamNo");
        String awardAuditResult = inMap.get("awardAuditResult");


        return outMap;
    }


    @RequestMapping(value="getBonusBySno",method=RequestMethod.POST)
    public Map getBonusBySno(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String sno = inMap.get("sno");


        return outMap;
    }

    @RequestMapping(value="getStuBonus",method=RequestMethod.POST)
    public Map getStuBonus(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();


        return outMap;
    }

    @RequestMapping(value="getTeaBonus",method=RequestMethod.POST)
    public Map getTeaBonus(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();


        return outMap;
    }
}
