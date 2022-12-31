package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.BonusRuleDao;
import com.hhu20.jsgl.dao.CompetitionDao;
import com.hhu20.jsgl.dao.SqlSessionTool;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BonusRule {
    public static List<Map> selectAll(){
        List<Map> Bs;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            BonusRuleDao bonusRuleDao = new BonusRuleDao(sqlSession);
            Bs = bonusRuleDao.selectAll();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Bs;
    }

    public static void delete(String clevel){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            BonusRuleDao bonusRuleDao = new BonusRuleDao(sqlSession);
            bonusRuleDao.delete(clevel);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Map> select(String clevel){
        List<Map> Bs;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            BonusRuleDao bonusRuleDao = new BonusRuleDao(sqlSession);
            Bs = bonusRuleDao.select(clevel);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Bs;
    }
}
