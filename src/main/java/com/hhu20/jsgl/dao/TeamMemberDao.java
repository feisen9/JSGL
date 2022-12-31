package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.TeamMapper;
import com.hhu20.jsgl.mapper.TeamMemberMapper;
import org.apache.ibatis.session.SqlSession;

public class TeamMemberDao {
    private SqlSession sqlSession;
    private TeamMemberMapper teamMemberMapper;
    public TeamMemberDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        teamMemberMapper = sqlSession.getMapper(TeamMemberMapper.class);
    }
    public void updateTeamMembers(){

    }
}
