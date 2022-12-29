package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.CompetitionDao;
import com.hhu20.jsgl.dao.SqlSessionTool;
import com.hhu20.jsgl.dao.StudentDao;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CompetitionMaintenance {

    public static List<Map> getComptInfo(){
        List<Map> compts;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            CompetitionDao competitionDao = new CompetitionDao(sqlSession);
            compts = competitionDao.selectAll();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return compts;
    }

    public static void delete(String cno){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            CompetitionDao competitionDao = new CompetitionDao(sqlSession);
            competitionDao.delete(cno);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Map> select(String cno, String cname, String clevel,
                                   String organizer, String hostintitue){
        List<Map> compts;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            CompetitionDao competitionDao = new CompetitionDao(sqlSession);
            compts = competitionDao.selectByCondition(cno,cname,clevel,organizer,hostintitue);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return compts;
    }

    public static void add(){

    }

}
