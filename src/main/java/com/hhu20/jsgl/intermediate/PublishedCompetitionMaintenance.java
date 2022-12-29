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
}
