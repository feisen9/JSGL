package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.intermediate.LoginAndRegister;
import com.hhu20.jsgl.intermediate.UserMaintenance;
import com.hhu20.jsgl.pojo.Student;
import com.hhu20.jsgl.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/users",method={RequestMethod.PUT,RequestMethod.PUT})
public class UserMaintenanceController {
    @Autowired
    TokenUtil tokenUtil;
    @RequestMapping(value="stuUpdate",method=RequestMethod.PUT)
    public Map stuUpdate(@RequestBody Map<String,Object> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        String sname = (String) inMap.get("sname");
        String sno = (String) inMap.get("sno");
        String major = (String) inMap.get("major");
        String sex = (String) inMap.get("sex");
        Date enrollmentYear = (Date) inMap.get("enrollmentYear");
        String academy = (String) inMap.get("academy");

        UserMaintenance.stuUpdate(sname,sno,major,sex,enrollmentYear,academy);
        /*
        todo
        check 更新成功
         */
        outMap.put("state","200");

        return outMap;
    }

    @RequestMapping(value="teaUpdate",method=RequestMethod.PUT)
    public Map teaUpdate(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        String tname = inMap.get("tname");
        String tno = inMap.get("tno");
        String sex = inMap.get("sex");
        String academy = inMap.get("academy");

        UserMaintenance.teaUpdate(tname,tno,sex,academy);
         /*
        todo
        check 更新成功
         */
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
        String userid = inMap.get("userid");

        LoginAndRegister.delete(userid);
        if(LoginAndRegister.checkRegister(userid)){
            //失败
            outMap.put("state","4004");
        }else{
            outMap.put("state","200");
        }

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
        if(rList.size()!=1){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        Map<String, Object> s = new TreeMap<String,Object>();
        for(int i = 0; i < rList.size(); i += 1){
            s.put("sname", (String) rList.get(i).get("sname"));
            s.put("sno", (String) rList.get(i).get("sno"));
            s.put("major", (String) rList.get(i).get("mname"));
            s.put("sex", (String) rList.get(i).get("ssex"));
            s.put("enrollmentYear", rList.get(i).get("enrollmentyear"));
            s.put("academy", (String) rList.get(i).get("dname"));
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

        List<Map> rList = UserMaintenance.getTeaInfoById(tno,false);
        if(rList==null){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        if(rList.size()!=1){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        Map<String,Object> map = new TreeMap<>();
        for(int i = 0; i < rList.size(); i += 1){
            map.put("tname",rList.get(i).get("tname"));
            map.put("tno",rList.get(i).get("tno"));
            map.put("sex",rList.get(i).get("tsex"));
            map.put("academy",rList.get(i).get("dname"));
        }
        outMap.put("state","200");
        outMap.put("data",map);

        return outMap;
    }

    @RequestMapping(value="getStuInfo",method=RequestMethod.POST)
    public Map getStuInfo(@RequestBody(required = false) Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
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
        for(Object s: rList.get(0).keySet()){
            System.out.println((String)s);
        }
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
    public Map getTeaInfo(@RequestBody(required = false) Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        List<Map> rList = UserMaintenance.getTeaInfoById("",true);
        if(rList==null){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        for(Object s: rList.get(0).keySet()){
            System.out.println((String)s);
        }
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        for(int i = 0; i < rList.size(); i += 1){
            Map<String, Object> map = new TreeMap<>();
            map.put("tname",rList.get(i).get("tname"));
            map.put("tno",rList.get(i).get("tno"));
            map.put("sex",rList.get(i).get("tsex"));
            map.put("academy",rList.get(i).get("dname"));
            data.add(map);
        }
        outMap.put("state","200");
        outMap.put("data",data);

        return outMap;
    }

    @RequestMapping(value="addStu",method=RequestMethod.POST)
    public Map addStu(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
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
    public Map updatePassword(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        String userid = inMap.get("userId");
        String password = inMap.get("password");

        UserMaintenance.userUpdate(userid, password);
        outMap.put("state","200");

        return outMap;
    }

    @RequestMapping(value="getUserInfo",method=RequestMethod.POST)
    public Map getUserInfo(@RequestBody(required = false) Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        List<Map> rList = LoginAndRegister.select("",true);
        if(rList==null){
            //查询失败
            outMap.put("state","4004");
            return outMap;
        }
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        for(int i = 0; i < rList.size(); i += 1){
            Map<String, Object> map = new TreeMap<>();
            map.put("userId",rList.get(i).get("userid"));
            map.put("password",rList.get(i).get("password"));
            map.put("userType",rList.get(i).get("usertype"));
            map.put("userName",rList.get(i).get("username"));
            data.add(map);
        }
        outMap.put("data",data);
        outMap.put("state","200");

        return outMap;
    }




}
