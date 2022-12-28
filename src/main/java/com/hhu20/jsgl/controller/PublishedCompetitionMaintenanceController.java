package com.hhu20.jsgl.controller;

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
        String pname = inMap.get("pname");
        String pstate = inMap.get("pstate");
        String regCollectTime = inMap.get("regCollectTime");
        String regDeadline = inMap.get("regDeadline");
        String awardCollectTime = inMap.get("awardCollectTime");
        String awardDeadline = inMap.get("awardDeadline");
        String sMaxNum = inMap.get("sMaxNum");
        String tMaxNum = inMap.get("tMaxNum");


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
            map.put("pstate",rList.get(i).get("pstate"));
            map.put("regCollectTime",rList.get(i).get("r_info_collect_time"));
            map.put("regdeadline",rList.get(i).get("r_info_deadline"));
            map.put("awardCollectTime",rList.get(i).get("a_info_collect_time"));
            map.put("awardDeadline",rList.get(i).get("a_info_deadline"));
            map.put("sMaxNum",rList.get(i).get("smaxnum"));
            map.put("tMaxNum",rList.get(i).get("tmaxnum"));
            data.add(map);
        }
        outMap.put("state","200");
        outMap.put("date",data);

        return outMap;
    }

    @RequestMapping(value="update",method=RequestMethod.PUT)
    public Map update(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String pno = inMap.get("pno");
        String pname = inMap.get("pname");
        String pstate = inMap.get("pstate");
        String regCollectTime = inMap.get("regCollectTime");
        String regDeadline = inMap.get("regDeadline");
        String awardCollectTime = inMap.get("awardCollectTime");
        String awardDeadline = inMap.get("awardDeadline");
        String sMaxNum = inMap.get("sMaxNum");
        String tMaxNum = inMap.get("tMaxNum");


        return outMap;
    }

    @RequestMapping(value="delete",method=RequestMethod.POST)
    public Map delete(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String pno = inMap.get("pno");


        return outMap;
    }

    @RequestMapping(value="searchPublishedCompt",method=RequestMethod.POST)
    public Map searchPublishedCompt(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String pno = inMap.get("pno");
        String pname = inMap.get("pname");
        String pstate = inMap.get("pstate");
        String regCollectTime = inMap.get("regCollectTime");
        String regDeadline = inMap.get("regDeadline");
        String awardCollectTime = inMap.get("awardCollectTime");
        String awardDeadline = inMap.get("awardDeadline");
        String sMaxNum = inMap.get("sMaxNum");
        String tMaxNum = inMap.get("tMaxNum");


        return outMap;
    }

}
