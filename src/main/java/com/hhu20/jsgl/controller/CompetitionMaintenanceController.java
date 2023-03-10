package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.intermediate.CompetitionMaintenance;
import com.hhu20.jsgl.util.TokenUtil;
import com.mysql.cj.jdbc.SuspendableXAConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/compts",method={RequestMethod.POST,RequestMethod.PUT})
public class CompetitionMaintenanceController {
    @Autowired
    TokenUtil tokenUtil;
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

        List<Map> rList = CompetitionMaintenance.getComptInfo();
        if(rList==null){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        for(int i = 0; i < rList.size(); i += 1){
            Map<String,Object> map = new TreeMap<>();
            map.put("cno",rList.get(i).get("cno"));
            map.put("cname",rList.get(i).get("cname"));
            map.put("clevel",rList.get(i).get("clevel"));
            map.put("organizer",rList.get(i).get("organizer"));
            map.put("hostinstitue",rList.get(i).get("hostinstitue"));

            data.add(map);
        }
        outMap.put("state","200");
        outMap.put("data",data);

        return outMap;
    }

    @RequestMapping(value="update",method=RequestMethod.PUT)
    public Map update(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String cno = inMap.get("cno");
        String cname = inMap.get("cname");
        String clevel = inMap.get("clevel");
        String organizer = inMap.get("organizer");
        String hostinstitue = inMap.get("hostinstitue");

        CompetitionMaintenance.update(cno,cname,clevel,organizer,hostinstitue);
        outMap.put("state","200");

        return outMap;
    }

    @RequestMapping(value="add",method=RequestMethod.POST)
    public Map add(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        String cname = inMap.get("cname");
        String clevel = inMap.get("clevel");
        String organizer = inMap.get("organizer");
        String hostinstitue = inMap.get("hostinstitue");

        List<Map> test = CompetitionMaintenance.select(null,cname,clevel,organizer,hostinstitue);
//        System.out.println(test.size());
        if(test.size()!=0){
            outMap.put("state","4001");
            return outMap;
        }

        CompetitionMaintenance.add(null,cname,clevel,organizer,hostinstitue);
        List<Map> rList = CompetitionMaintenance.select(null,cname,clevel,organizer,hostinstitue);
        if(rList==null || rList.size()!=1){
            outMap.put("state","4003");
            return outMap;
        }
        if(rList.get(0).get("cno")==null){
            outMap.put("state","4003");
            return outMap;
        }
        outMap.put("state","200");
        Map<String, Object> data = new TreeMap<>();
        data.put("cno",rList.get(0).get("cno"));
        outMap.put("data",data);
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
        String cno = inMap.get("cno");

        CompetitionMaintenance.delete(cno);
        List<Map> rList = CompetitionMaintenance.select(cno,null,null,null,null);
        if(rList.size()>0){
            //失败
            outMap.put("state","4007");
            return outMap;
        }
        outMap.put("state","200");

        return outMap;
    }

    @RequestMapping(value="searchComptInfo",method=RequestMethod.POST)
    public Map searchComptInfo(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
//        for(String k: inMap.keySet()){
//            System.out.println(k);
//        }
        String cno = inMap.get("cno");
        String cname = inMap.get("cname");
        String clevel = inMap.get("clevel");
        String organizer = inMap.get("organizer");
        String hostinstitue = inMap.get("hostinstitue");

        List<Map> rList = CompetitionMaintenance.select(cno,cname,clevel,organizer,hostinstitue);
        if(rList==null){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        for(int i = 0; i < rList.size(); i += 1){
            Map<String,Object> map = new TreeMap<>();
            map.put("cno",rList.get(i).get("cno"));
            map.put("cname",rList.get(i).get("cname"));
            map.put("clevel",rList.get(i).get("clevel"));
            map.put("organizer",rList.get(i).get("organizer"));
            map.put("hostinstitue",rList.get(i).get("hostinstitue"));
            data.add(map);
        }
        outMap.put("state","200");
        outMap.put("data",data);


        return outMap;
    }



}
