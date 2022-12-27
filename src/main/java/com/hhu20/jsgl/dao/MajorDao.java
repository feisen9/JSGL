package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.DeptMapper;
import com.hhu20.jsgl.mapper.MajorMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MajorDao {
    private SqlSession sqlSession;
    private MajorMapper majorMapper;
    public MajorDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        majorMapper = sqlSession.getMapper(MajorMapper.class);
    }
    public List<Map> selectAll(){
        return majorMapper.selectAll();
    }

    public String selectMnameForMno(String mname){
        String mno = majorMapper.selectMnameForMno(mname);
        return mno;
    }
}
