package com.hhu20.jsgl;

import com.hhu20.jsgl.dao.SqlSessionTool;
import com.hhu20.jsgl.dao.StudentDao;
import com.hhu20.jsgl.dao.TeacherDao;
import com.hhu20.jsgl.mapper.DeptMapper;
import com.hhu20.jsgl.mapper.StudentMapper;
import com.hhu20.jsgl.pojo.ADVISORS;
import com.hhu20.jsgl.pojo.Dept;
import com.hhu20.jsgl.pojo.Student;
import com.hhu20.jsgl.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyBatisTestDemo {
    public static void main(String[] args) throws Exception {
        //获取sqlSession（固定不需要改，且只用调用一次）
        SqlSessionTool sqlSessionTool = new SqlSessionTool();
        SqlSession sqlSession = sqlSessionTool.getSqlSession();

        //学生对象的Dao类实例化
        StudentDao studentDao = new StudentDao(sqlSession);



        //选择不同的查询方法获取数据库查询结果
        //-----------------------------------------
        //查询所有
//        List<Map> students = studentDao.selectAll();
//
        //-------------------------------------------
        //按学号查
//        List<Map> students = studentDao.selectSNO("20628");
        //--------------------------------------------
        //通过实例化对象和对象的setter方法传递参数。
//        Student student = new Student();
////        student.setSNO("20628101");
//        student.setMNO("cs0005");
//        List<Map> students = studentDao.selectByObject(student);

        //--------------------------------------------
//        //插入单个学生
        Student student = new Student();
        student.setSNO("2062810127");
        student.setMNO("cs0001");
        student.setSSEX("男");
        student.setSNAME("邹烨");
        Calendar calendar= Calendar.getInstance();
        calendar.set(2020, 9, 1);  //年月日  也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52);
        Date date=calendar.getTime();//date就是你需要的时间
        student.setENROLLMENTYEAR(date);
        studentDao.insertStu(student);

        List<Map> students = studentDao.selectAll();
        System.out.println(students);

        //关闭sqlSession释放资源
        sqlSession.close();

    }
}
