package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.AwardMapper;
import com.hhu20.jsgl.utils.FuzzyQueryStr;
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
    //学生上报获奖信息
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

    // 修改获奖信息
    public void updateAwardInfo(int teamNo, List<Map> teamMembers,List<Map> advisors,int pno,String awardInfo) throws Exception
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

    //审核获奖信息
    public void auditAwardInfo(String teamno,String awardAuditResult) throws Exception {
        TeamDao teamDao = new TeamDao(sqlSession);
        teamDao.updateAwardAuditResult(teamno,awardAuditResult);
    }
    public List<Map> searchAward(int pno,String cname,String awardInfo,String sno,String sname,String tno,String tname,String awardAuditResult){
        return awardMapper.searchAward(pno, FuzzyQueryStr.bilateralFuzzy(cname), awardInfo, sno, FuzzyQueryStr.bilateralFuzzy(sname), tno, FuzzyQueryStr.bilateralFuzzy(tname), awardAuditResult);
    }

    //获取所有奖金信息
//    public List<Map> getAwardInfo(){
//        awardMapper
//    }
}
