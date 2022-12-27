package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.StudentMapper;
import com.hhu20.jsgl.mapper.TeacherMapper;
import com.hhu20.jsgl.pojo.Teacher;
import com.hhu20.jsgl.utils.FuzzyQueryStr;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TeacherDao {
    private SqlSession sqlSession;
    private TeacherMapper teacherMapper;
    public TeacherDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    }
    public List<Teacher> selectAll(){
        return teacherMapper.selectAll();
    }
    public List<Teacher> selectTNO(String tno){
        return teacherMapper.selectTNO(FuzzyQueryStr.unilateralFuzzy(tno));
    }
}
