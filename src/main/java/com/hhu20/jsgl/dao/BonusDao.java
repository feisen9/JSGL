package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.AwardMapper;
import com.hhu20.jsgl.mapper.BonusMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BonusDao {
    private SqlSession sqlSession;
    private BonusMapper bonusMapper;
    public BonusDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        bonusMapper = sqlSession.getMapper(BonusMapper.class);
    }

    public List<Map> selectAllTeaBonus(){
        return bonusMapper.selectAllTeaBonus();
    }

    public List<Map> selectAllStuBonus(){
        return bonusMapper.selectAllStuBonus();
    }

}
