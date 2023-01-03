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

public class Bonus {
    public static List<Map> getStuBonus(){
        List<Map> data = new ArrayList<>();
        try{
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            BonusDao bonusDao = new BonusDao(sqlSession);
            List<Map> results = bonusDao.selectAllStuBonus();
            for(Map result:results){
                Map<String, Object> map = new TreeMap<>();
                map.put("sno",result.get("sno"));
                map.put("pno",result.get("pno"));
                map.put("teamNo",result.get("teamno"));
                map.put("cname",result.get("cname"));
                map.put("clevel",result.get("clevel"));
                map.put("bonusAmount",result.get("bonusAmount"));
                data.add(map);
            }
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public static List<Map> getTeaBonus(){
        List<Map> data = new ArrayList<>();
        try{
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            BonusDao bonusDao = new BonusDao(sqlSession);
            List<Map> results = bonusDao.selectAllTeaBonus();
            for(Map result:results){
                Map<String, Object> map = new TreeMap<>();
                map.put("tno",result.get("tno"));
                map.put("pno",result.get("pno"));
                map.put("teamNo",result.get("teamno"));
                map.put("cname",result.get("cname"));
                map.put("clevel",result.get("clevel"));
                map.put("bonusAmount",result.get("bonusAmount"));
                data.add(map);
            }
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public static List<Map> searchBonus(String sno,String tno,Integer pno,String usertype){
        List<Map> data = null;
        try{
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            BonusDao bonusDao = new BonusDao(sqlSession);
            data = bonusDao.searchBonus(sno,tno,pno,usertype);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return data;
    }

}
