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

    public static int add(String clevel, String stu_1, String stu_2, String stu_3,
                                String stu_no, String stu_t,  String tea_1, String tea_2, String tea_3,
                                String tea_no, String tea_t,String team_1, String team_2, String team_3,
                                String team_no, String team_t){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            BonusRuleDao bonusRuleDao = new BonusRuleDao(sqlSession);
            int rows = bonusRuleDao.add(clevel, stu_1, stu_2, stu_3,stu_no,stu_t,
                    tea_1, tea_2, tea_3,tea_no,tea_t,
                    team_1, team_2, team_3,team_no,team_t);
            if(rows != 1) {
                throw new RuntimeException("插入奖金规则时出现未知错误，请联系系统管理员");
            }
            sqlSession.close();
            return 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(String clevel, String stu_1, String stu_2, String stu_3,
                           String stu_no, String stu_t,  String tea_1, String tea_2, String tea_3,
                           String tea_no, String tea_t,String team_1, String team_2, String team_3,
                           String team_no, String team_t){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            BonusRuleDao bonusRuleDao = new BonusRuleDao(sqlSession);
            bonusRuleDao.update(clevel, stu_1, stu_2, stu_3,stu_no,stu_t,
                    tea_1, tea_2, tea_3,tea_no,tea_t,
                    team_1, team_2, team_3,team_no,team_t);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
