package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.MajorMapper;
import com.hhu20.jsgl.mapper.StudentMapper;
import com.hhu20.jsgl.pojo.Student;
import com.hhu20.jsgl.utils.FuzzyQueryStr;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StudentDao {
    private SqlSession sqlSession;
    private StudentMapper studentMapper;
    public StudentDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }
    public List<Map> selectAll(){
        List<Map> students = studentMapper.selectAll();
        return students;
    }
    public List<Map> selectSNO(String sno){     //支持学号模糊查询
        List<Map> students = studentMapper.selectSNO(FuzzyQueryStr.unilateralFuzzy(sno));
        return students;
    }
    public List<Map> select(String sno){     //支持学号模糊查询
        List<Map> students = studentMapper.select(sno);
        return students;
    }
    public List<Map> selectByObject(Student student){   //支持学号、专业号、姓名、性别部分或全部参与模糊查询，传入的对象没有setter的成员变量处理为不参与查询
        //动态的查询参数需要用student对象的setter方法实例化为一个对象传进来
        List<Map> students = studentMapper.selectByCondition(
                FuzzyQueryStr.unilateralFuzzy(student.getSNO()),
                FuzzyQueryStr.unilateralFuzzy(student.getMNO()),
                FuzzyQueryStr.unilateralFuzzy(student.getSNAME()),
                student.getSSEX());
        return students;
    }
    public int insertStu(String sname, String sno , String major, String sex ,
                         String enrollmentYear , String academy) throws Exception{
        int rows = studentMapper.insertStu(sname,sno,major,sex,enrollmentYear,academy);
        sqlSession.commit();    //提交事务
        return rows;
    }

    public void updateStu(String sname, String sno , String major, String sex ,
                          String enrollmentYear , String academy) throws Exception{

        //通过MajorDao查出major对应的mno
        MajorDao majorDao = new MajorDao(sqlSession);
        String mno = majorDao.selectMnameForMno(major);
        studentMapper.updateStu(sno,mno,sname,sex,enrollmentYear);
    }

    public int deleteOne(String sno){
        return studentMapper.deleteOne(sno);
    }
}
