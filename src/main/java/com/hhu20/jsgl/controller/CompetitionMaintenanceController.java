package com.hhu20.jsgl.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value="/compts",method={RequestMethod.POST,RequestMethod.PUT})
public class CompetitionMaintenanceController {
    @RequestMapping(value="getComptInfo",method=RequestMethod.POST)
    public Map getComptInfo(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();

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
        String bno = inMap.get("bno");


        return outMap;
    }

    @RequestMapping(value="add",method=RequestMethod.POST)
    public Map add(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String cname = inMap.get("cname");
        String clevel = inMap.get("clevel");
        String organizer = inMap.get("organizer");
        String hostinstitue = inMap.get("hostinstitue");


        return outMap;
    }

    @RequestMapping(value="delete",method=RequestMethod.POST)
    public Map delete(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String cno = inMap.get("cno");


        return outMap;
    }

    @RequestMapping(value="searchComptInfo",method=RequestMethod.POST)
    public Map searchComptInfo(@RequestBody Map<String,String> inMap){
        Map<String, Object> outMap = new TreeMap<>();
        String cno = inMap.get("cno");
        String cname = inMap.get("cname");
        String clevel = inMap.get("clevel");
        String organizer = inMap.get("organizer");
        String hostinstitue = inMap.get("hostinstitue");
        String bno = inMap.get("bno");


        return outMap;
    }



}
