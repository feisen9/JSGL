package com.hhu20.jsgl.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/bonusRule",method={RequestMethod.PUT,RequestMethod.POST})
public class BonusRuleController {
    @RequestMapping(value="getBonusInfo",method=RequestMethod.POST)
    public Map getBonusInfo(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();


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
    public Map delete(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String bno = inMap.get("bno");


        return outMap;
    }

    @RequestMapping(value="getBonusInfoByBno",method=RequestMethod.POST)
    public Map getBonusInfoByBno(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String bno = inMap.get("bno");


        return outMap;
    }
}
