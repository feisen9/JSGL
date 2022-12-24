package com.hhu20.jsgl.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/teams",method={RequestMethod.PUT,RequestMethod.POST})
public class SignUp4CompetitionController {
    @RequestMapping(value="reg",method=RequestMethod.POST)
    public Map reg(@RequestBody Map<String,Object> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        Map<String, Object> data = (Map)inMap.get("data");


        return outMap;
    }

    @RequestMapping(value="cancel",method=RequestMethod.POST)
    public Map cancel(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String teamNo = inMap.get("teamNo");


        return outMap;
    }

    @RequestMapping(value="update",method=RequestMethod.PUT)
    public Map update(@RequestBody Map<String,Object> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        Map<String, Object> data = (Map)inMap.get("data");


        return outMap;
    }

    @RequestMapping(value="auditRegInfo",method=RequestMethod.POST)
    public Map auditRegInfo(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String teamNo = inMap.get("teamNo");
        String regAuditResult = inMap.get("regAuditResult");


        return outMap;
    }
}
