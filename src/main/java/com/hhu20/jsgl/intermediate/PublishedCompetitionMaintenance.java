package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.CompetitionDao;
import com.hhu20.jsgl.dao.Part4;
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
            Part4 part4 = new Part4(sqlSession);
            pcompts = part4.selectAllPC();
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

    public static List<Map> select(String pno, String cname, String pstate, String pperson, String pyear,
                                   String r_info_collect_time,String a_info_collect_time,
                                   String r_info_deadline ,String a_info_deadline ,String smaxnum, String tmaxnum){
        List<Map> pcompts;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            Part4 part4 = new Part4(sqlSession);
            pcompts = part4.selectPC(pno, cname, pstate, pperson, pyear, r_info_collect_time, a_info_collect_time,
                    r_info_deadline , a_info_deadline, smaxnum, tmaxnum);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pcompts;
    }

    public static void update(String PNO,String PSTATE,String pperson, String pyear, String R_INFO_COLLECT_TIME,
                                   String A_INFO_COLLECT_TIME,String R_INFO_DEADLINE,String A_INFO_DEADLINE,
                                   String SMAXNUM,String TMAXNUM){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            PublishedCompetitionDao publishedCompetitionDao= new PublishedCompetitionDao(sqlSession);
            publishedCompetitionDao.update(PNO,PSTATE, pperson,pyear, R_INFO_COLLECT_TIME,
                    A_INFO_COLLECT_TIME, R_INFO_DEADLINE, A_INFO_DEADLINE,
                    SMAXNUM, TMAXNUM);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void add(String cno, String pstate, String pperson, String  pyear, String r_info_collect_time,
                           String a_info_collect_time, String r_info_deadline , String a_info_deadline,
                           String smaxnum, String tmaxnum){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            Part4 part4 = new Part4(sqlSession);
            part4.insertP(cno, pstate, pperson, pyear, r_info_collect_time, a_info_collect_time,
                    r_info_deadline , a_info_deadline, smaxnum, tmaxnum);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
