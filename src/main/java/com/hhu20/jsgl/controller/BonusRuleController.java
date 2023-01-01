package com.hhu20.jsgl.controller;

import com.hhu20.jsgl.intermediate.BonusRule;
import com.hhu20.jsgl.intermediate.PublishedCompetitionMaintenance;
import com.hhu20.jsgl.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/bonusRule",method={RequestMethod.PUT,RequestMethod.POST})
public class BonusRuleController {
    @Autowired
    TokenUtil tokenUtil;
    @RequestMapping(value="getBonusInfo",method=RequestMethod.POST)
    public Map getBonusInfo(@RequestBody(required = false) Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }

        List<Map> rList = BonusRule.selectAll();
        if(rList==null){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        for(int i = 0; i < rList.size(); i += 1){
            Map<String,Object> map = rList.get(i);
            data.add(map);
        }
        outMap.put("state","200");
        outMap.put("data",data);


        return outMap;
    }

    @RequestMapping(value="update",method=RequestMethod.PUT)
    public Map update(@RequestBody Map<String, String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String clevel = inMap.get("clevel");
        String stu_1 = inMap.get("stu_1");
        String stu_2 = inMap.get("stu_2");
        String stu_3 = inMap.get("stu_3");
        String stu_no = inMap.get("stu_no");
        String stu_t = inMap.get("stu_t");
        String tea_1 = inMap.get("tea_1");
        String tea_2 = inMap.get("tea_2");
        String tea_3 = inMap.get("tea_3");
        String tea_no = inMap.get("tea_no");
        String tea_t = inMap.get("tea_t");
        String team_1 = inMap.get("team_1");
        String team_2 = inMap.get("team_2");
        String team_3 = inMap.get("team_3");
        String team_no = inMap.get("team_no");
        String team_t = inMap.get("team_t");

        BonusRule.update(clevel, stu_1, stu_2, stu_3,stu_no,stu_t,
                tea_1, tea_2, tea_3,tea_no,tea_t,
                team_1, team_2, team_3,team_no,team_t);

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
        String clevel = inMap.get("clevel");
        String stu_1 = inMap.get("stu_1");
        String stu_2 = inMap.get("stu_2");
        String stu_3 = inMap.get("stu_3");
        String stu_no = inMap.get("stu_no");
        String stu_t = inMap.get("stu_t");
        String tea_1 = inMap.get("tea_1");
        String tea_2 = inMap.get("tea_2");
        String tea_3 = inMap.get("tea_3");
        String tea_no = inMap.get("tea_no");
        String tea_t = inMap.get("tea_t");
        String team_1 = inMap.get("team_1");
        String team_2 = inMap.get("team_2");
        String team_3 = inMap.get("team_3");
        String team_no = inMap.get("team_no");
        String team_t = inMap.get("team_t");

        int rows = BonusRule.add(clevel, stu_1, stu_2, stu_3,stu_no,stu_t,
                tea_1, tea_2, tea_3,tea_no,tea_t,
                team_1, team_2, team_3,team_no,team_t);

        if(rows == 1)
            outMap.put("state","200");
        else
            outMap.put("state","4003");
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
        String clevel = inMap.get("clevel");

        BonusRule.delete(clevel);
        outMap.put("state","200");

        return outMap;
    }

    @RequestMapping(value="searchBonusRule",method=RequestMethod.POST)
    public Map getBonusInfoByBno(@RequestBody Map<String,String> inMap, @RequestHeader Map<String,String> tokenMap){
        Map<String, Object> outMap = new TreeMap<>();
        String token = tokenMap.get("authorization");
        String userId = tokenUtil.verifyToken(token);
        if(userId==null){
            //token 过期
            outMap.put("state","5000");
            return outMap;
        }
        String clevel = inMap.get("clevel");

        List<Map> rList = BonusRule.select(clevel);
        if(rList==null){
            //查询失败
            outMap.put("state","7001");
            return outMap;
        }

        outMap.put("state","200");
        if(rList.size()>0) {
            outMap.put("data", rList.get(0));
        }

        return outMap;
    }
}
