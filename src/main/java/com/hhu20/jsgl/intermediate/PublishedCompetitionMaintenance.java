package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.CompetitionDao;
import com.hhu20.jsgl.dao.PublishedCompetitionDao;
import com.hhu20.jsgl.dao.SqlSessionTool;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PublishedCompetitionMaintenance {
    public static List<Map> selectAll(){
        List<Map> pcompts;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            PublishedCompetitionDao publishedCompetitionDao= new PublishedCompetitionDao(sqlSession);
            pcompts = publishedCompetitionDao.selectAll();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pcompts;
    }

    public static void delete(String pno){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            PublishedCompetitionDao publishedCompetitionDao= new PublishedCompetitionDao(sqlSession);
            publishedCompetitionDao.delete(pno);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Map> select(String PNO,String CNO,String PSTATE,String R_INFO_COLLECT_TIME,
                                   String A_INFO_COLLECT_TIME,String R_INFO_DEADLINE,String A_INFO_DEADLINE,
                                   String SMAXNUM,String TMAXNUM){
        List<Map> pcompts;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            PublishedCompetitionDao publishedCompetitionDao= new PublishedCompetitionDao(sqlSession);
            pcompts = publishedCompetitionDao.selectByCondition(PNO,CNO,PSTATE,R_INFO_COLLECT_TIME,
                    A_INFO_COLLECT_TIME,R_INFO_DEADLINE,A_INFO_DEADLINE, SMAXNUM,TMAXNUM);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pcompts;
    }

    public static void update(String PNO,String CNO,String PSTATE,String R_INFO_COLLECT_TIME,
                                   String A_INFO_COLLECT_TIME,String R_INFO_DEADLINE,String A_INFO_DEADLINE,
                                   String SMAXNUM,String TMAXNUM){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            PublishedCompetitionDao publishedCompetitionDao= new PublishedCompetitionDao(sqlSession);
            publishedCompetitionDao.update(PNO,CNO,PSTATE,R_INFO_COLLECT_TIME,
                    A_INFO_COLLECT_TIME,R_INFO_DEADLINE,A_INFO_DEADLINE, SMAXNUM,TMAXNUM);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void add(String PNO,String CNO,String PSTATE,String R_INFO_COLLECT_TIME,
                              String A_INFO_COLLECT_TIME,String R_INFO_DEADLINE,String A_INFO_DEADLINE,
                              String SMAXNUM,String TMAXNUM){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            PublishedCompetitionDao publishedCompetitionDao= new PublishedCompetitionDao(sqlSession);
            publishedCompetitionDao.add(null,CNO,PSTATE,R_INFO_COLLECT_TIME,
                    A_INFO_COLLECT_TIME,R_INFO_DEADLINE,A_INFO_DEADLINE, SMAXNUM,TMAXNUM);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
