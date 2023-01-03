package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.AwardDao;
import com.hhu20.jsgl.dao.BonusDao;
import com.hhu20.jsgl.dao.SqlSessionTool;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Award {

    public static int add(Integer teamNo, List<Map> teamMembers,List<Map> advisors,Integer pno,String awardInfo) {
        int rows = -1;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            AwardDao awardDao = new AwardDao(sqlSession);
            rows = awardDao.addAwardInfo(teamNo, teamMembers, advisors, pno, awardInfo);
            awardDao.commit();
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException("插入获奖信息时出现未知错误，请联系系统管理员");
        }
        return rows;
    }

    public static int update(Integer teamNo, List<Map> teamMembers,List<Map> advisors,Integer pno,String awardInfo){
        int rows=-1;
        try{
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            AwardDao awardDao = new AwardDao(sqlSession);
            rows = awardDao.updateAwardInfo(teamNo, teamMembers, advisors, pno, awardInfo);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    public static int auditAwardInfo(String teamno,String awardAuditResult){
        int rows=-1;
        try{
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            AwardDao awardDao = new AwardDao(sqlSession);
            rows = awardDao.auditAwardInfo(teamno, awardAuditResult);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    public static List<Map> search(Integer pno, String cname, String awardInfo, String sno, String sname, String tno, String tname, String awardAuditResult){
        List<Map> data;
        try{
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            AwardDao awardDao = new AwardDao(sqlSession);
            data = awardDao.searchAward(pno, cname, awardInfo, sno, sname, tno, tname, awardAuditResult);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public static List<Map> getAwardInfo(){
        List<Map> data = new ArrayList<>();
        try{
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            AwardDao awardDao = new AwardDao(sqlSession);
            data = awardDao.searchAward(null,null,null,null,null,null,null,null);
//            for(Map result:results){
//                Map<String, Object> map = new TreeMap<>();
//                map.put("teamNo",result.get("teamno"));
//                map.put("teamMembers",result.get("teamMembers"));
//                map.put("advisors",result.get("advisors"));
//                map.put("pno",result.get("pno"));
//                map.put("awardInfo",result.get("awardinfo"));
//                map.put("awardAuditResult",result.get("a_audit_result"));
//                data.add(map);
//            }
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public static int delete(Integer teamNo){
        int rows = -1;
        try{
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            AwardDao awardDao = new AwardDao(sqlSession);
            rows = awardDao.deleteAwardInfo(teamNo);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

}
