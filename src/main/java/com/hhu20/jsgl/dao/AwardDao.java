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
    public void commit(){
        sqlSession.commit();
    }
//    public selectAwardInfo(int pno,String cname,String awardInfo,String sno,String sname,String tno,String tname,String awardAuditResult){
//
//    }
    //学生上报获奖信息
    public int addAwardInfo(int teamNo, List<Map> teamMembers,List<Map> advisors,int pno,String awardInfo) throws Exception
    {
        //先更新team表中的pno和awardInfo
        TeamDao teamDao = new TeamDao(sqlSession);
        int teamrows = teamDao.updatePnoandAwardInfo(teamNo,pno,awardInfo);
        //更新teammember表中的队员赋分系数
        TeamMemberDao teamMemberDao = new TeamMemberDao(sqlSession);
        teamMemberDao.updateTeamMembers(teamMembers,teamNo);
        //更新advisors表中老师的赋分系数
        AdvisorsDao advisorsDao = new AdvisorsDao(sqlSession);
        advisorsDao.update(advisors,teamNo);
        return teamrows;
    }

    // 修改获奖信息
    public int updateAwardInfo(int teamNo, List<Map> teamMembers,List<Map> advisors,int pno,String awardInfo) throws Exception
    {
        int rows = 0;
        //先更新team表中的pno和awardInfo
        TeamDao teamDao = new TeamDao(sqlSession);
        rows = teamDao.updatePnoandAwardInfo(teamNo,pno,awardInfo);
        //更新teammember表中的队员赋分系数
        TeamMemberDao teamMemberDao = new TeamMemberDao(sqlSession);
        teamMemberDao.updateTeamMembers(teamMembers,teamNo);
        //更新advisors表中老师的赋分系数
        AdvisorsDao advisorsDao = new AdvisorsDao(sqlSession);
        advisorsDao.update(advisors,teamNo);
        return rows;
    }

    //审核获奖信息
    public int auditAwardInfo(String teamno,String awardAuditResult) throws Exception {
        TeamDao teamDao = new TeamDao(sqlSession);
        return teamDao.updateAwardAuditResult(teamno,awardAuditResult);
    }
    public List<Map> searchAward(int pno,String cname,String awardInfo,String sno,String sname,String tno,String tname,String awardAuditResult){
        return awardMapper.searchAward(pno, FuzzyQueryStr.bilateralFuzzy(cname), awardInfo, sno, FuzzyQueryStr.bilateralFuzzy(sname), tno, FuzzyQueryStr.bilateralFuzzy(tname), awardAuditResult);
    }

    //获取所有获奖信息
    public List<Map> getAwardInfo(){
        List<Map> outMap = awardMapper.getAwardInfo();
        TeamMemberDao teamMemberDao = new TeamMemberDao(sqlSession);
        AdvisorsDao advisorsDao = new AdvisorsDao(sqlSession);
        //后端查询队员和指导老师的赋分系数，增加两个字段
        for(int i=0;i<outMap.size();i++){
            Map temp = outMap.get(i);
            List<Map> teamMembers = teamMemberDao.selectByTeamno((Integer) temp.get("teamno"));
            temp.put("teamMembers",teamMembers);
            List<Map> advisors = advisorsDao.selectByTeamno((Integer) temp.get("teamno"));
            temp.put("advisors",advisors);
        }
        return outMap;
    }
    public void deleteAwardInfo(int teamno){
        awardMapper.deleteAwardInfo(teamno);
    }
}
