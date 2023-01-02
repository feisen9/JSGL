package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.CompetitionMapper;
import com.hhu20.jsgl.mapper.PublishedCompetitionMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class PublishedCompetitionDao {
    private SqlSession sqlSession;
    private PublishedCompetitionMapper publishedCompetitionMapper;
    public PublishedCompetitionDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        publishedCompetitionMapper = (PublishedCompetitionMapper) sqlSession.getMapper(PublishedCompetitionMapper.class);
    }

    public List<Map> selectAll(){
        List<Map> outMap = publishedCompetitionMapper.selectAll();
        return outMap;
    }

    public  List<Map> add(String PNO,String CNO,String PSTATE,String R_INFO_COLLECT_TIME,String A_INFO_COLLECT_TIME,String R_INFO_DEADLINE,String A_INFO_DEADLINE,String SMAXNUM,String TMAXNUM) {
        List<Map> outMap = publishedCompetitionMapper.add(PNO,CNO,PSTATE,R_INFO_COLLECT_TIME,A_INFO_COLLECT_TIME,R_INFO_DEADLINE,A_INFO_DEADLINE,SMAXNUM,TMAXNUM);
        return outMap;
    }

    public List<Map> delete(String PNO){
        List<Map> outMap = publishedCompetitionMapper.delete(PNO);
        return outMap;
    }

    public List<Map> update(String PNO,String PSTATE,String pperson, String pyear, String R_INFO_COLLECT_TIME,
                            String A_INFO_COLLECT_TIME,String R_INFO_DEADLINE,String A_INFO_DEADLINE,
                            String SMAXNUM,String TMAXNUM) {
        List<Map> outMap = publishedCompetitionMapper.update(PNO,PSTATE, pperson,pyear, R_INFO_COLLECT_TIME,
                 A_INFO_COLLECT_TIME, R_INFO_DEADLINE, A_INFO_DEADLINE,
                SMAXNUM, TMAXNUM);
        return outMap;
    }


    public List<Map> selectByCondition(String PNO,String CNO,String PSTATE,String R_INFO_COLLECT_TIME,String A_INFO_COLLECT_TIME,String R_INFO_DEADLINE,String A_INFO_DEADLINE,String SMAXNUM,String TMAXNUM) {
        List<Map> outMap = publishedCompetitionMapper.selectByCondition(PNO,CNO,PSTATE,R_INFO_COLLECT_TIME,A_INFO_COLLECT_TIME,R_INFO_DEADLINE,A_INFO_DEADLINE,SMAXNUM,TMAXNUM);
        return outMap;
    }
}
