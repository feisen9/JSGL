package com.hhu20.jsgl;

import com.hhu20.jsgl.dao.SqlSessionTool;
import com.hhu20.jsgl.dao.StudentDao;
import com.hhu20.jsgl.mapper.DeptMapper;
import com.hhu20.jsgl.mapper.StudentMapper;
import com.hhu20.jsgl.pojo.Dept;
import com.hhu20.jsgl.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTestDemo {
    public static void main(String[] args) throws IOException {
        //MyBatis调用数据库示例（固定不需要改）
        SqlSessionTool sqlSessionTool = new SqlSessionTool();
        SqlSession sqlSession = sqlSessionTool.getSqlSession();

        //对应对象的Dao类实例化
        StudentDao studentDao = new StudentDao(sqlSession);

        //选择调用方法获取数据库查询结果
        //-----------------------------------------
        //List<Student> students = studentDao.selectAll();
        //-------------------------------------------
        //List<Student> students = studentDao.selectSNO("20628101");
        //--------------------------------------------
        //通过实例化对象和对象的setter方法传递参数。
        Student student = new Student();
//        student.setSNO("20628101");
        student.setMNO("cs0005");
        List<Student> students = studentDao.selectByObject(student);
        //--------------------------------------------
        System.out.println(students);

        sqlSession.close();
    }
}
