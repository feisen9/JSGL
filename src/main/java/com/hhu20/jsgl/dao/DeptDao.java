package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.DeptMapper;
import com.hhu20.jsgl.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class DeptDao {
    private SqlSession sqlSession;
    private DeptMapper deptMapper;
    public DeptDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        deptMapper = sqlSession.getMapper(DeptMapper.class);
    }
    public List<Map> selectAll(){
        return deptMapper.selectAll();
    }
    public List<String> selectDnameForDno(String dname){
        List<String> dnos = deptMapper.selectDnameForDno(dname);
        return dnos;
    }
}
