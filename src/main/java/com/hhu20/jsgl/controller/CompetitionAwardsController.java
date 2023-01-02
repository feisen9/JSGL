package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.intermediate.Award;
import com.hhu20.jsgl.intermediate.Bonus;
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
        String teamNostr = (String) data.get("pno");
        Integer teamNo = null;
        if(!teamNostr.equals("")){
            teamNo = Integer.valueOf(teamNostr);
        }

        String pnostr = (String) data.get("pno");
        Integer pno = null;
        if(!pnostr.equals("")){
            pno = Integer.valueOf(pnostr);
        }

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
        String teamNostr = (String) data.get("pno");
        Integer teamNo = null;
        if(!teamNostr.equals("")){
            teamNo = Integer.valueOf(teamNostr);
        }

        String pnostr = (String) data.get("pno");
        Integer pno = null;
        if(!pnostr.equals("")){
            pno = Integer.valueOf(pnostr);
        }
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


        String pnostr = (String) inMap.get("pno");
        Integer pno = null;
        if(!pnostr.equals("")){
            pno = Integer.valueOf(pnostr);
        }
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


    @RequestMapping(value="searchBonus",method=RequestMethod.POST)
    public Map searchBonus(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        String pnostr = inMap.get("pno");
        Integer pno = null;
        if(!pnostr.equals("")){
            pno = Integer.valueOf(pnostr);
        }
        String sno = inMap.get("sno");
        String tno = inMap.get("tno");
        List<Map> result = Bonus.searchBonus(sno,tno,pno);
        outMap.put("state","200");
        outMap.put("data",result);
        return outMap;
    }


    @RequestMapping(value="getStuBonus",method=RequestMethod.POST)
    public Map getStuBonus(@RequestBody(required = false) Map<String,String> inMap , @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        List<Map> resultList = Bonus.getStuBonus();
        outMap.put("state","200");
        outMap.put("data",resultList);
        return outMap;

    }

    @RequestMapping(value="getTeaBonus",method=RequestMethod.POST)
    public Map getTeaBonus(@RequestBody(required = false) Map<String,String> inMap , @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        List<Map> resultList = Bonus.getTeaBonus();
        outMap.put("state","200");
        outMap.put("data",resultList);
        return outMap;
    }

    @RequestMapping(value="getAwardInfo",method=RequestMethod.POST)
    public Map getAwardInfo(@RequestBody(required = false) Map<String,String> inMap , @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        List<Map> resultList = Award.getAwardInfo();
        outMap.put("state","200");
        outMap.put("data",resultList);
        return outMap;
    }

    @RequestMapping(value="delete",method=RequestMethod.POST)
    public Map delete(@RequestBody Map<String,String> inMap , @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

//        int teamNo = Integer.parseInt(inMap.get("teamNo"));
        String teamNostr = (String) inMap.get("pno");
        Integer teamNo = null;
        if(!teamNostr.equals("")){
            teamNo = Integer.valueOf(teamNostr);
        }
        int rows = Award.delete(teamNo);
        if(rows == 1)
            outMap.put("state","200");
        else
            outMap.put("state","4007");
        return outMap;
    }
}
