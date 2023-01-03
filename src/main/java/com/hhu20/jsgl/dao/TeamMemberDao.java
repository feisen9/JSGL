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
    public void updateTeamMembers(List<Map> teamMembers,Integer teamNo) throws Exception{       //更新队员
        for(Map teamMember : teamMembers){
            teamMember.put("sofficient",Double.parseDouble(teamMember.get("sofficient").toString()));
            teamMemberMapper.updateTeammembers((Double) teamMember.get("sofficient"), (String) teamMember.get("sno"),teamNo);
        }
    }
    public List<Map> selectByTeamno(int teamno){
        List<Map> outMap = teamMemberMapper.selectByTeamno(teamno);
        //改变键名与前端对应
        for(int i=0;i<outMap.size();i++){
            float sofficient = (float) outMap.get(i).get("scofficient");
            outMap.get(i).remove("scofficient");
            outMap.get(i).put("sofficient",sofficient);
        }
        return outMap;

    }
}
