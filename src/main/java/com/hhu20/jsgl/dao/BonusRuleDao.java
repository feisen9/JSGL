package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.BonusRuleMapper;
import com.hhu20.jsgl.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BonusRuleDao {
    private SqlSession sqlSession;
    private BonusRuleMapper bonusRuleMapper;
    public BonusRuleDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        bonusRuleMapper = (BonusRuleMapper) sqlSession.getMapper(BonusRuleMapper.class);
    }

    public List<Map> selectAll(){
        List<Map> outMap = bonusRuleMapper.selectAll();
        return outMap;
    }

    public List<Map> update(String clevel, String stu_1, String stu_2, String stu_3,
                            String stu_no, String stu_t,  String tea_1, String tea_2, String tea_3,
                            String tea_no, String tea_t,String team_1, String team_2, String team_3,
                            String team_no, String team_t){
        List<Map> outMap = bonusRuleMapper.update(clevel, stu_1, stu_2, stu_3,stu_no,stu_t,
                tea_1, tea_2, tea_3,tea_no,tea_t,
                team_1, team_2, team_3,team_no,team_t);
        return outMap;
    }

    public int add(String clevel, String stu_1, String stu_2, String stu_3,
                         String stu_no, String stu_t,  String tea_1, String tea_2, String tea_3,
                         String tea_no, String tea_t,String team_1, String team_2, String team_3,
                         String team_no, String team_t){
        int outMap = bonusRuleMapper.add(clevel, stu_1, stu_2, stu_3,stu_no,stu_t,
                tea_1, tea_2, tea_3,tea_no,tea_t,
                team_1, team_2, team_3,team_no,team_t);
        return outMap;
    }

    public List<Map> delete(String clevel){
        List<Map> outMap = bonusRuleMapper.delete(clevel);
        return outMap;
    }

    public List<Map> select(String clevel){
        List<Map> outMap = bonusRuleMapper.select(clevel);
        return outMap;
    }
}
