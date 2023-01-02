package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.dao.CompetitionDao;
import com.hhu20.jsgl.intermediate.CompetitionMaintenance;
import com.hhu20.jsgl.intermediate.PublishedCompetitionMaintenance;
import com.hhu20.jsgl.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/ComptsPublished",method={RequestMethod.POST,RequestMethod.PUT})
public class PublishedCompetitionMaintenanceController {
    @Autowired
    TokenUtil tokenUtil;
    @RequestMapping(value="publishCompt",method=RequestMethod.POST)
    public Map publishCompt(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        String cno = inMap.get("cno");
        String pperson = inMap.get("pperson");
        String pyear = inMap.get("pyear");
        String pstate = inMap.get("pstate");
        String regCollectTime = inMap.get("regCollectTime");
        String regDeadline = inMap.get("regDeadline");
        String awardCollectTime = inMap.get("awardCollectTime");
        String awardDeadline = inMap.get("awardDeadline");
        String sMaxNum = inMap.get("sMaxNum");
        String tMaxNum = inMap.get("tMaxNum");

        PublishedCompetitionMaintenance.add(cno,pstate,pperson,pyear,regCollectTime,awardCollectTime,regDeadline,
                awardDeadline,sMaxNum,tMaxNum);
        List<Map> ccc = CompetitionMaintenance.select(cno,null,null,null,null);
        if(ccc.size()!=1){
            outMap.put("state","4003");
            return outMap;
        }
        String cname = (String) ccc.get(0).get("cname");

        List<Map> rList = PublishedCompetitionMaintenance.select(null,cname,pstate,pperson,pyear,regCollectTime,awardCollectTime,regDeadline,
                awardDeadline,sMaxNum,tMaxNum);
        System.out.println(rList.size());
        if(rList==null || rList.size()!=1){
            outMap.put("state","4003");
            return outMap;
        }
        if(rList.get(0).get("pno")==null){
            outMap.put("state","4003");
            return outMap;
        }
        outMap.put("state","200");
        Map<String, Object> data = new TreeMap<>();
        data.put("pno",rList.get(0).get("pno"));
        outMap.put("data",data);

        return outMap;
    }

    @RequestMapping(value="getComptInfo",method=RequestMethod.POST)
    public Map getComptInfo(@RequestBody(required = false) Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        List<Map> rList = PublishedCompetitionMaintenance.selectAll();
        if(rList==null){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        for(int i = 0; i < rList.size(); i += 1){
            Map<String,Object> map = new TreeMap<>();
            map.put("pno",rList.get(i).get("pno"));
            map.put("cname",rList.get(i).get("cname"));
            map.put("pstate",rList.get(i).get("pstate"));
            map.put("pperson",rList.get(i).get("pperson"));
            map.put("pyear",rList.get(i).get("pyear"));
            map.put("regCollectTime",rList.get(i).get("r_info_collect_time"));
            map.put("regdeadline",rList.get(i).get("r_info_deadline"));
            map.put("awardCollectTime",rList.get(i).get("a_info_collect_time"));
            map.put("awardDeadline",rList.get(i).get("a_info_deadline"));
            map.put("sMaxNum",rList.get(i).get("smaxnum"));
            map.put("tMaxNum",rList.get(i).get("tmaxnum"));
            data.add(map);
        }
        outMap.put("state","200");
        outMap.put("data",data);

        return outMap;
    }

    @RequestMapping(value="update",method=RequestMethod.PUT)
    public Map update(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        for(String s: inMap.keySet()){
            System.out.println(s+" "+inMap.get(s));
        }
        String pno = inMap.get("pno");
        String cname = inMap.get("cname");
        String pstate = inMap.get("pstate");
        String pperson = inMap.get("pperson");
        String pyear = inMap.get("pyear");
        String regCollectTime = inMap.get("regCollectTime");
        if(regCollectTime!=null && regCollectTime.length()>=19) {
            regCollectTime = regCollectTime.substring(0, 19);
        }
        String regDeadline = (String) inMap.get("regDeadline");
        if(regDeadline!=null&&regDeadline.length()>=19) {
            regDeadline = regDeadline.substring(0, 19);
        }
        String awardCollectTime = (String) inMap.get("awardCollectTime");
        if(awardCollectTime!=null&&awardCollectTime.length()>=19) {
            awardCollectTime = awardCollectTime.substring(0, 19);
        }
        String awardDeadline = (String) inMap.get("awardDeadline");
        if(awardDeadline!=null&&awardDeadline.length()>=19) {
            awardDeadline = awardDeadline.substring(0, 19);
        }
        String sMaxNum = inMap.get("sMaxNum");
        String tMaxNum = inMap.get("tMaxNum");

        PublishedCompetitionMaintenance.update(pno,pstate,pperson,pyear,regCollectTime,awardCollectTime,
                regDeadline,awardDeadline,sMaxNum,tMaxNum);
        outMap.put("state","200");

        return outMap;
    }

    @RequestMapping(value="delete",method=RequestMethod.POST)
    public Map delete(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        String pno = inMap.get("pno");

        PublishedCompetitionMaintenance.delete(pno);
        outMap.put("state","200");

        return outMap;
    }

    @RequestMapping(value="searchPublishedCompt",method=RequestMethod.POST)
    public Map searchPublishedCompt(@RequestBody Map<String,Object> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        for(String k: inMap.keySet()){
            System.out.println(k);
        }for(Object k: inMap.values()){
            System.out.println(k);
        }

        String pno = (String) inMap.get("pno");
//        String pno = null;
        String cname = (String) inMap.get("cname");
        String pperson = (String) inMap.get("pperson");
        String pyear = (String) inMap.get("pyear");
        String pstate = (String) inMap.get("pstate");
        String regCollectTime = (String) inMap.get("regCollectTime");
        if(regCollectTime!=null && regCollectTime.length()>=19) {
            regCollectTime = regCollectTime.substring(0, 19);
        }
        String regDeadline = (String) inMap.get("regDeadline");
        if(regDeadline!=null&&regDeadline.length()>=19) {
            regDeadline = regDeadline.substring(0, 19);
        }
        String awardCollectTime = (String) inMap.get("awardCollectTime");
        if(awardCollectTime!=null&&awardCollectTime.length()>=19) {
            awardCollectTime = awardCollectTime.substring(0, 19);
        }
        String awardDeadline = (String) inMap.get("awardDeadline");
        if(awardDeadline!=null&&awardDeadline.length()>=19) {
            awardDeadline = awardDeadline.substring(0, 19);
        }
        String sMaxNum = (String) inMap.get("sMaxNum");
        String tMaxNum = (String) inMap.get("tMaxNum");
        System.out.println("cname: "+cname);
        List<Map> rList = PublishedCompetitionMaintenance.select(pno,cname,pstate,pperson,pyear,regCollectTime,awardCollectTime,
                regDeadline,awardDeadline,sMaxNum,tMaxNum);
        if(rList==null){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        for(int i = 0; i < rList.size(); i += 1){
            Map<String,Object> map = new TreeMap<>();
            map.put("pno",rList.get(i).get("pno"));
            map.put("cname",rList.get(i).get("cname"));
            map.put("pstate",rList.get(i).get("pstate"));
            map.put("pperson",rList.get(i).get("pperson"));
            map.put("pyear",rList.get(i).get("pyear"));
            map.put("regCollectTime",rList.get(i).get("r_info_collect_time"));
            map.put("regdeadline",rList.get(i).get("r_info_deadline"));
            map.put("awardCollectTime",rList.get(i).get("a_info_collect_time"));
            map.put("awardDeadline",rList.get(i).get("a_info_deadline"));
            map.put("sMaxNum",rList.get(i).get("smaxnum"));
            map.put("tMaxNum",rList.get(i).get("tmaxnum"));
            data.add(map);
        }
        outMap.put("state","200");
        outMap.put("data",data);

        return outMap;
    }

}
