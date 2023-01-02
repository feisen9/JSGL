package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.intermediate.SignUp4Competition;
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
        /*
        前端接口
         */
//        for (String s: inMap.keySet()){
//            System.out.println(s);
//        }
//        Map<String, Object> data = (Map)inMap.get("data");
        Map<String, Object> data = inMap;
        String teamName = (String) data.get("teamName");
        String pno = (String) data.get("pno");
        List<Map> teamMembers = (List<Map>) data.get("teamMembers");
        List<Map> advisors = (List<Map>) data.get("advisors");

        Map<String,String> result = SignUp4Competition.teamInsert(teamName,pno,teamMembers,advisors);
        if(!result.get("state").equals("200")){
            return result;
        }
        outMap.put("state","200");
        outMap.put("teamNo",result.get("teamno"));
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

        SignUp4Competition.deleteTeam(teamNo);
        outMap.put("state","200");

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
        String teamName = (String) data.get("teamName");
        String teamNo = (String) data.get("teamNo");
        String pno = (String) data.get("pno");
        List<Map> teamMembers = (List<Map>) data.get("teamMembers");
        List<Map> advisors = (List<Map>) data.get("advisors");

        Map<String,String> rMap = SignUp4Competition.update(teamNo,teamName,pno,teamMembers,advisors);
        return rMap;
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

        SignUp4Competition.updateTeamR(teamNo,regAuditResult);
        outMap.put("state","200");

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

        List<Map> data = SignUp4Competition.selectAll();
        if(data == null){
            outMap.put("state","4003");
        }else{
            outMap.put("data",data);
            outMap.put("state","200");
        }

        return outMap;
    }

    @RequestMapping(value="searchRegInfo",method=RequestMethod.POST)
    public Map searchRegInfo(@RequestBody Map<String,Object> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
//        Map<String, Object> data = (Map)inMap.get("data");
        Map<String, Object> data = inMap;
        String pno = (String) data.get("pno");
        String cname = (String) data.get("cname");
        String sno = (String) data.get("sno");
        String sname = (String) data.get("sname");
        String tno = (String) data.get("tno");
        String tname = (String) data.get("tname");
        String regAuditResult = (String) data.get("regAuditResult");

        List<Map> outdata = SignUp4Competition.select(pno,cname,sno,sname,tno,tname,regAuditResult);
        if(data == null){
            outMap.put("state","4003");
        }else{
            outMap.put("data",outdata);
            outMap.put("state","200");
        }

        return outMap;
    }
}
