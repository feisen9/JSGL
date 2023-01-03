package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.TeacherMapper;
import com.hhu20.jsgl.mapper.TeamMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class TeamDao {
    private SqlSession sqlSession;
    private TeamMapper teamMapper;
    public TeamDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        teamMapper = sqlSession.getMapper(TeamMapper.class);
    }
    public List<Map> selectAll(){
        return teamMapper.selectAll();
    }
    public int updatePnoandAwardInfo(Integer teamno, Integer pno, String awardinfo) throws Exception{
        return teamMapper.updatePnoandAwardInfo(teamno,pno,awardinfo);
    };
    public int addPnoandAwardInfo (Integer teamno, Integer pno, String awardinfo) throws Exception {
        return teamMapper.addPnoandAwardInfo(teamno,pno,awardinfo);
    }

    //更新获奖信息审核信息
    public int updateAwardAuditResult(String teamNo, String awardAuditResult) throws Exception{
        return teamMapper.updateAwardAuditResult(teamNo,awardAuditResult);
    }
}
