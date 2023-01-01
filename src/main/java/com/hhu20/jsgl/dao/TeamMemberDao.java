package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.TeamMapper;
import com.hhu20.jsgl.mapper.TeamMemberMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class TeamMemberDao {
    private SqlSession sqlSession;
    private TeamMemberMapper teamMemberMapper;
    public TeamMemberDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        teamMemberMapper = sqlSession.getMapper(TeamMemberMapper.class);
    }
    public void updateTeamMembers(List<Map> teamMembers,int teamNo) throws Exception{       //更新队员
        for(Map teamMember : teamMembers){
            teamMemberMapper.updateTeammembers((Float) teamMember.get("sofficient"), (String) teamMember.get("sno"),teamNo);
        }
    }
//    public List<Map> selectByTeamno(int teamno){
//
//    }
}
