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

    public List<Map> update(String bno, String s_firstprize_amount, String s_secondprize_amount, String s_thirdprize_amount,
                            String s_noprize_amount, String t_firstprize_amount, String t_secondprize_amount, String t_thirdprize_amount,
                            String t_noprize_amount){
        List<Map> outMap = bonusRuleMapper.update(bno, s_firstprize_amount, s_secondprize_amount, s_thirdprize_amount,
                s_noprize_amount, t_firstprize_amount, t_secondprize_amount, t_thirdprize_amount,
                t_noprize_amount);
        return outMap;
    }

    public List<Map> add(String bno, String s_firstprize_amount, String s_secondprize_amount, String s_thirdprize_amount,
                         String s_noprize_amount, String t_firstprize_amount, String t_secondprize_amount, String t_thirdprize_amount,
                         String t_noprize_amount){
        List<Map> outMap = bonusRuleMapper.add(bno, s_firstprize_amount, s_secondprize_amount, s_thirdprize_amount,
                s_noprize_amount, t_firstprize_amount, t_secondprize_amount, t_thirdprize_amount,
                t_noprize_amount);
        return outMap;
    }

    public List<Map> delete(String bno){
        List<Map> outMap = bonusRuleMapper.delete(bno);
        return outMap;
    }

    public List<Map> select(String bno){
        List<Map> outMap = bonusRuleMapper.select(bno);
        return outMap;
    }
}
