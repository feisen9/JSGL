package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.StudentMapper;
import com.hhu20.jsgl.pojo.Student;
import com.hhu20.jsgl.utils.FuzzyQueryStr;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class StudentDao {
    private SqlSession sqlSession;
    private StudentMapper studentMapper;
    public StudentDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }
    public List<Student> selectAll(){
        List<Student> students = studentMapper.selectAll();
        return students;
    }
    public List<Student> selectSNO(String sno){     //支持学号模糊查询
        List<Student> students = studentMapper.selectSNO(FuzzyQueryStr.unilateralFuzzy(sno));
        return students;
    }
    public List<Student> selectByObject(Student student){   //支持学号、专业号、姓名、性别部分或全部参与模糊查询，传入的对象没有setter的成员变量处理为不参与查询
        //动态的查询参数需要用student对象的setter方法实例化为一个对象传进来
        List<Student> students = studentMapper.selectByCondition(
                FuzzyQueryStr.unilateralFuzzy(student.getSNO()),
                FuzzyQueryStr.unilateralFuzzy(student.getMNO()),
                FuzzyQueryStr.unilateralFuzzy(student.getSNAME()),
                student.getSSEX());
        return students;
    }
}
