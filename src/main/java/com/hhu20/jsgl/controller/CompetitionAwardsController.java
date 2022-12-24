package com.hhu20.jsgl.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/awards",method={RequestMethod.PUT,RequestMethod.POST})
public class CompetitionAwardsController {
    @RequestMapping(value="add",method=RequestMethod.POST)
    public Map add(@RequestBody Map<String,Object> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        Map<String,Object> data = (Map)inMap.get("data");


        return outMap;
    }

    @RequestMapping(value="update",method=RequestMethod.PUT)
    public Map update(@RequestBody Map<String,Object> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        Map<String,Object> data = (Map)inMap.get("data");


        return outMap;
    }

    @RequestMapping(value="auditAwardInfo",method=RequestMethod.POST)
    public Map auditAwardInfo(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String teamNo = inMap.get("teamNo");
        String awardAuditResult = inMap.get("awardAuditResult");


        return outMap;
    }


    @RequestMapping(value="getBonusBySno",method=RequestMethod.POST)
    public Map getBonusBySno(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String sno = inMap.get("sno");


        return outMap;
    }

    @RequestMapping(value="getStuBonus",method=RequestMethod.POST)
    public Map getStuBonus(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();


        return outMap;
    }

    @RequestMapping(value="getTeaBonus",method=RequestMethod.POST)
    public Map getTeaBonus(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();


        return outMap;
    }
}
