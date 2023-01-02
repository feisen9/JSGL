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
    public Map auditAwardInfo(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        String awardAuditResult = inMap.get("awardAuditResult");
        String teamNo = inMap.get("teamNo");

        int rows = Award.auditAwardInfo(teamNo,awardAuditResult);
        if(rows == 1)
            outMap.put("state","200");
        else
            outMap.put("state","4004");
        return outMap;
    }

    @RequestMapping(value="search",method=RequestMethod.POST)
    public Map search(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        int pno = Integer.parseInt(inMap.get("pno"));
        String cname = inMap.get("cname");
        String awardInfo = inMap.get("awardInfo");
        String sno = inMap.get("sno");
        String sname = inMap.get("sname");
        String tno = inMap.get("tno");
        String tname = inMap.get("tname");
        String awardAuditResult = inMap.get("awardAuditResult");

        List<Map> resultList = Award.search(pno,cname,awardInfo,sno,sname,tno,tname,awardAuditResult);
        outMap.put("data",resultList);
        outMap.put("state","200");
        return outMap;
    }


    @RequestMapping(value="getBonusBySno",method=RequestMethod.POST)
    public Map getBonusBySno(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
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
