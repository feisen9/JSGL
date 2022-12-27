package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.intermediate.UserMaintenance;
import com.hhu20.jsgl.pojo.Student;
import com.hhu20.jsgl.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        List<Student> studentList = UserMaintenance.getStuInfoById(sno,false);




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

        List<Student> studentList = UserMaintenance.getStuInfoById("None",false);

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
