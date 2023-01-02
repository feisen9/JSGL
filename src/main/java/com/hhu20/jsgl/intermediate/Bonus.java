package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.AwardDao;
import com.hhu20.jsgl.dao.BonusDao;
import com.hhu20.jsgl.dao.SqlSessionTool;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Bonus {
    public static List<Map> getStuBonus(){
        List<Map> data = null;
        try{
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            BonusDao bonusDao = new BonusDao(sqlSession);
            data = bonusDao.selectAllStuBonus();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public static List<Map> getTeaBonus(){
        List<Map> data = null;
        try{
            SqlSessionTool sqlSessionTool = new SqlSessionTool(false);
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            BonusDao bonusDao = new BonusDao(sqlSession);
            data = bonusDao.selectAllTeaBonus();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return data;
    }

}
