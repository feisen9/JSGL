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
    public void addAwardInfo(String teamNo, List<Map> teamMembers,List<Map> advisors,int pno,String awardInfo){
        
    }
}
