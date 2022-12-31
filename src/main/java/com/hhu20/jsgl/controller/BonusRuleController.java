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
    public Map update(@RequestBody Map<String, Object> inMap){
        Map<String, Object> outMap = new TreeMap<>();
//        String data = inMap.get("data");
//

        return outMap;
    }

    @RequestMapping(value="add",method=RequestMethod.POST)
    public Map add(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String stuFirstPrize = inMap.get("stuFirstPrize");
        String stuSecondPrize = inMap.get("stuSecondPrize");
        String stuThirdPrize = inMap.get("stuThirdPrize");
        String stuNoPrize = inMap.get("stuNoPrize");
        String teaFirstPrize = inMap.get("teaFirstPrize");
        String teaSecondPrize = inMap.get("teaSecondPrize");
        String teaThirdPrize = inMap.get("teaThirdPrize");
        String teaNoPrize = inMap.get("teaNoPrize");


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
