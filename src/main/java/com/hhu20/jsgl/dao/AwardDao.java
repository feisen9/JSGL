package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.AdvisorsMapper;
import com.hhu20.jsgl.mapper.AwardMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class AwardDao {
    private SqlSession sqlSession;
    private AwardMapper awardMapper;
    public AwardDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        awardMapper = sqlSession.getMapper(AwardMapper.class);
    }

//    public selectAwardInfo(int pno,String cname,String awardInfo,String sno,String sname,String tno,String tname,String awardAuditResult){
//
//    }
    public void addAwardInfo(int teamNo, List<Map> teamMembers,List<Map> advisors,int pno,String awardInfo) throws Exception
    {
        //先更新team表中的pno和awardInfo
        TeamDao teamDao = new TeamDao(sqlSession);
        teamDao.updatePnoandAwardInfo(teamNo,pno,awardInfo);
        //更新teammember表中的队员赋分系数
        TeamMemberDao teamMemberDao = new TeamMemberDao(sqlSession);
        teamMemberDao.updateTeamMembers(teamMembers,teamNo);
        //更新advisors表中老师的赋分系数
        AdvisorsDao advisorsDao = new AdvisorsDao(sqlSession);
        advisorsDao.update(advisors,teamNo);
    }
}
