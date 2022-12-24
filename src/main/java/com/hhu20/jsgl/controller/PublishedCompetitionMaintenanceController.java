package com.hhu20.jsgl.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/ComptsPublished",method={RequestMethod.POST,RequestMethod.PUT})
public class PublishedCompetitionMaintenanceController {
    @RequestMapping(value="publishCompt",method=RequestMethod.POST)
    public Map publishCompt(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
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
    public Map getComptInfo(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();


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
