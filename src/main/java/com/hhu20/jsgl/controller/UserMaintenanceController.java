package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.intermediate.UserMaintenance;
import com.hhu20.jsgl.pojo.Student;
import com.hhu20.jsgl.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/users",method={RequestMethod.PUT,RequestMethod.PUT})
public class UserMaintenanceController {
    @Autowired
    TokenUtil tokenUtil;
    @RequestMapping(value="stuUpdate",method=RequestMethod.PUT)
    public Map stuUpdate(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        String sname = inMap.get("sname");
        String sno = inMap.get("sno");
        String major = inMap.get("major");
        String sex = inMap.get("sex");
        String enrollmentYear = inMap.get("enrollmentYear");
        String academy = inMap.get("academy");


        return outMap;
    }

    @RequestMapping(value="teaUpdate",method=RequestMethod.PUT)
    public Map teaUpdate(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String tname = inMap.get("tname");
        String tno = inMap.get("tno");
        String sex = inMap.get("sex");
        String academy = inMap.get("academy");


        return outMap;
    }

    @RequestMapping(value="delete",method=RequestMethod.POST)
    public Map delete(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String userid = inMap.get("userid");


        return outMap;
    }

    @RequestMapping(value="getStuInfoById",method=RequestMethod.POST)
    public Map getStuInfoById(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        String sno = inMap.get("sno");

        List<Map> rList = UserMaintenance.getStuInfoById(sno,false);
        if(rList==null){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        Map<String, Object> s = new TreeMap<String,Object>();
        for(int i = 0; i < rList.size(); i += 1){
            s.put("sname", (String) rList.get(i).get("SNAME"));
            s.put("sno", (String) rList.get(i).get("SNO"));
            s.put("major", (String) rList.get(i).get("MNAME"));
            s.put("sex", (String) rList.get(i).get("SSEX"));
            s.put("enrollmentYear", rList.get(i).get("ENROLLMENTYEAR"));
            s.put("academy", (String) rList.get(i).get("DNAME"));
        }
        outMap.put("data",s);
        outMap.put("state","200");




        return outMap;
    }

    @RequestMapping(value="getTeaInfoById",method=RequestMethod.POST)
    public Map getTeaInfoById(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        String tno = inMap.get("tno");


        return outMap;
    }

    @RequestMapping(value="getStuInfo",method=RequestMethod.POST)
    public Map getStuInfo(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        List<Map> rList = UserMaintenance.getStuInfoById("None",true);
        if(rList==null){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        List<Map<String,Object>> data = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < rList.size(); i += 1){
            Map<String, Object> s = new TreeMap<String,Object>();
            s.put("sname", (String) rList.get(i).get("sname"));
            s.put("sno", (String) rList.get(i).get("sno"));
            s.put("major", (String) rList.get(i).get("mname"));
            s.put("sex", (String) rList.get(i).get("ssex"));
            s.put("enrollmentYear",  rList.get(i).get("enrollmentyear"));
            s.put("academy", (String) rList.get(i).get("dname"));
            data.add(s);
        }
        outMap.put("data",data);
        outMap.put("state","200");

        return outMap;
    }

    @RequestMapping(value="getTeaInfo",method=RequestMethod.POST)
    public Map getTeaInfo(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
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

    @RequestMapping(value="addStu",method=RequestMethod.POST)
    public Map addStu(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String sname = inMap.get("sname");
        String sno = inMap.get("sno");
        String major = inMap.get("major");
        String sex = inMap.get("sex");
        String enrollmentYear = inMap.get("enrollmentYear");
        String academy = inMap.get("academy");


        return outMap;
    }

    @RequestMapping(value="addTea",method=RequestMethod.POST)
    public Map addTea(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String tname = inMap.get("tname");
        String tno = inMap.get("tno");
        String sex = inMap.get("sex");
        String academy = inMap.get("academy");


        return outMap;
    }

    @RequestMapping(value="updatePassword",method=RequestMethod.PUT)
    public Map updatePassword(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String userId = inMap.get("userId");
        String password = inMap.get("password");


        return outMap;
    }

    @RequestMapping(value="getUserInfo",method=RequestMethod.POST)
    public Map getUserInfo(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("Authorization");

        return outMap;
    }




}
