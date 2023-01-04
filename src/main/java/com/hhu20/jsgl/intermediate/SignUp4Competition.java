package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.*;
import com.hhu20.jsgl.mapper.Part5Mapper;
import org.apache.ibatis.session.SqlSession;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.time.Instant;
import java.util.*;
public class SignUp4Competition {

    public static Map update(String teamNo, String teamname, String pno, List<Map> teamMembers, List<Map> advisors){
        Map<String, String> outMap = new TreeMap<>();
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            Part5 part5 = new Part5(sqlSession);
            TeacherDao teacherDao = new TeacherDao(sqlSession);
            StudentDao studentDao = new StudentDao(sqlSession);

            for(Map stu: teamMembers){
                String sno = (String) stu.get("sno");
                String sname = (String) stu.get("sname");
                List<Map> rList = studentDao.select(sno);
                if(rList.size()!=1){
                    System.out.println("队员不存在");
                    sqlSession.close();
                    outMap.put("state","4004");
                    return outMap;
                }
                if(!rList.get(0).get("sname").equals(sname)){
                    System.out.println("队员信息有误");
                    sqlSession.close();
                    outMap.put("state","4004");
                    return outMap;
                }
            }
            for(Map tea: advisors){
                String tno = (String) tea.get("tno");
                String tname = (String) tea.get("tname");
                List<Map> rList = teacherDao.select(tno);
                if(rList.size()!=1){
                    System.out.println("指导老师不存在");
                    sqlSession.close();
                    outMap.put("state","4004");
                    return outMap;
                }
            }
            List<Map> rList = part5.checkTeam(teamNo);
            if(rList.size()!=1){
                System.out.println("队伍不存在");
                sqlSession.close();
                outMap.put("state","4004");
                return outMap;
            }

            part5.updateTeam(teamNo,pno,teamname);
            part5.deleteStuTea(teamNo);

            for(Map stu : teamMembers){
                String sno = (String) stu.get("sno");
                part5.teammemberInsert(sno,teamNo);
            }
            for(Map tea: advisors){
                String tno = (String) tea.get("tno");
                part5.advisorInsert(tno,teamNo);
            }
            AwardDao awardDao = new AwardDao(sqlSession);
            awardDao.deleteAwardInfo(Integer.valueOf(teamNo));
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        outMap.put("state","200");
        return outMap;
    }

    public static void updateTeamR(String teamno, String r_audit_result){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            Part5 part5 = new Part5(sqlSession);
            part5.updateTeamR(teamno,r_audit_result);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteTeam(String teamNo){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            Part5 part5 = new Part5(sqlSession);
            part5.deleteTeam(teamNo);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Map> select(String pno, String cname, String sno, String sname,
                                   String tno, String tname, String regAuditResult){
        Map<String, Object> outMap= new TreeMap<>();
        List<Map> data = new ArrayList<>();
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            Part5 part5 = new Part5(sqlSession);
            List<Map> rList = part5.selectTeamCT(pno,cname,sno,sname,tno,tname,regAuditResult);
            for(Map team: rList){
                Map<String, Object> map = new TreeMap<>();
                map.put("teamName", team.get("teamname"));
                map.put("teamNo", team.get("teamno"));
                map.put("pno", Integer.toString((Integer)team.get("pno")));
                map.put("cname", team.get("cname"));
                map.put("regAuditResult", team.get("r_audit_result"));
                String teamno = Integer.toString((Integer)team.get("teamno"));
                map.put("teamMembers",part5.selectTStu(teamno));
                map.put("advisors",part5.selectTTea(teamno));
                data.add(map);
            }
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        outMap.put("data",data);
        return (List<Map>) data;
    }
    public static List<Map> selectAll(){
        Map<String, Object> outMap= new TreeMap<>();
        List<Map> data = new ArrayList<>();
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            Part5 part5 = new Part5(sqlSession);
            List<Map> rList = part5.selectTeamCT(null,null,null,null,
                    null,null,null);
            for(Map team: rList){
                Map<String, Object> map = new TreeMap<>();
                map.put("teamName", team.get("teamname"));
                map.put("teamNo", team.get("teamno"));
                map.put("pno", Integer.toString((Integer)team.get("pno")));
                map.put("cname", team.get("cname"));
                map.put("regAuditResult", team.get("r_audit_result"));
                String teamno = Integer.toString((Integer) team.get("teamno"));
                map.put("teamMembers",part5.selectTStu(teamno));
                map.put("advisors",part5.selectTTea(teamno));
                data.add(map);
            }
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        outMap.put("data",data);
        return data;
    }

    public static Map<String,String> teamInsert(String teamname, String pno, List<Map> teamMembers, List<Map> advisors){
        Map<String, String> outMap = new TreeMap<>();
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            Part5 part5 = new Part5(sqlSession);
            TeacherDao teacherDao = new TeacherDao(sqlSession);
            StudentDao studentDao = new StudentDao(sqlSession);

            for(Map stu: teamMembers){
                String sno = (String) stu.get("sno");
                String sname = (String) stu.get("sname");
                List<Map> rList = studentDao.select(sno);
                if(rList.size()!=1){
                    System.out.println("队员不存在");
                    sqlSession.close();
                    outMap.put("state","4003");
                    return outMap;
                }
                if(!rList.get(0).get("sname").equals(sname)){
                    System.out.println("队员信息有误");
                    sqlSession.close();
                    outMap.put("state","4003");
                    return outMap;
                }
            }

            for(Map tea: advisors){
                String tno = (String) tea.get("tno");
                String tname = (String) tea.get("tname");
                List<Map> rList = teacherDao.select(tno);
                if(rList.size()!=1){
                    System.out.println("指导老师不存在");
                    sqlSession.close();
                    outMap.put("state","4003");
                    return outMap;
                }
                if(!rList.get(0).get("tname").equals(tname)){
                    System.out.println("指导老师信息有误");
                    sqlSession.close();
                    outMap.put("state","4003");
                    return outMap;
                }
            }

            Instant date = new Date().toInstant();
            String datee = date.toString().substring(0,19);
            part5.teamInsert(teamname,pno, datee);
            List<Map> rList = part5.teamSelectN(null,pno,teamname,
                    datee,null,null);
            if(rList.size()!=1){
                System.out.println("出现错误");
                sqlSession.close();
                outMap.put("state","4003");
                return outMap;
            }
            String teamno =  Integer.toString((Integer) rList.get(0).get("teamno"));
            outMap.put("teamno",teamno);
            for(Map stu : teamMembers){
                String sno = (String) stu.get("sno");
                part5.teammemberInsert(sno,teamno);
            }
            for(Map tea: advisors){
                String tno = (String) tea.get("tno");
                part5.advisorInsert(tno,teamno);
            }

            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        outMap.put("state","200");
        return outMap;
    }

}
