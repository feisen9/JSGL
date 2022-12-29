package com.hhu20.jsgl.dao;
import com.hhu20.jsgl.mapper.CompetitionMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class CompetitionDao {
    private SqlSession sqlSession;
    private CompetitionMapper competitionMapper;
    public CompetitionDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        competitionMapper = (CompetitionMapper) sqlSession.getMapper(CompetitionMapper.class);
    }

    public List<Map> selectAll(){
        List<Map> outMap = competitionMapper.selectAll();
        return outMap;
    }
    public  List<Map> add(String cno, String cname, String clevel,
                         String organizer, String hostintitue){
        List<Map> outMap = competitionMapper.add(cno, cname, clevel,
                organizer, hostintitue);
        return outMap;
    }
    public List<Map> delete(String cno){
        List<Map> outMap = competitionMapper.delete(cno);
        return outMap;
    }

    public List<Map> update(String cno, String cname, String clevel,
                            String organizer, String hostintitue){
        List<Map> outMap = competitionMapper.update(cno, cname, clevel,
                organizer, hostintitue);
        return outMap;
    }


    public List<Map> selectByCondition(String cno, String cname, String clevel,
                                       String organizer, String hostintitue){
        List<Map> outMap = competitionMapper.selectByCondition(cno, cname, clevel,
                organizer, hostintitue);
        return outMap;
    }
}
