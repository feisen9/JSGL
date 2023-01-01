package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.StudentMapper;
import com.hhu20.jsgl.mapper.TeacherMapper;
import com.hhu20.jsgl.pojo.Student;
import com.hhu20.jsgl.pojo.Teacher;
import com.hhu20.jsgl.utils.FuzzyQueryStr;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class TeacherDao {
    private SqlSession sqlSession;
    private TeacherMapper teacherMapper;
    public TeacherDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    }
    public List<Map> selectAll(){
        return teacherMapper.selectAll();
    }
    public List<Map> selectTNO(String tno){
        return teacherMapper.selectTNO(FuzzyQueryStr.unilateralFuzzy(tno));
    }

    public List<Map> select(String tno){ return teacherMapper.select(tno);};

    public int insertTea(String tno,String tname,String tsex,String academy) throws Exception{
        Teacher teacher = new Teacher(tno,tname,tsex,academy);
        int rows = teacherMapper.insertTea(teacher);
        sqlSession.commit();    //提交事务
        return rows;
    }

    public void updateTea(String tno,String tname,String sex,String academy){
        DeptDao deptDao = new DeptDao(sqlSession);
        List<String> dno = deptDao.selectDnameForDno(academy);
        teacherMapper.updateTea(tname,tno,sex,dno.get(0));
    }
}
