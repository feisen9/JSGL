package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.TeacherMapper;
import com.hhu20.jsgl.mapper.TeamMapper;
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
    public void addAwardInfo(int teamNo, List<Map> teamMembers,List<Map> advisors,int pno,String awardInfo) throws Exception
    {
        teamMapper.updatePnoandAwardInfo(teamNo,pno,awardInfo);

    }
}
