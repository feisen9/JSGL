package com.hhu20.jsgl;

import com.hhu20.jsgl.dao.*;
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
import java.util.*;

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
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        calendar.setTimeZone(timeZone);
        calendar.set(2020, 8, 2,0,0,0);  //年月日(月份从0算起)  也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52);
        Date date=calendar.getTime();//date就是你需要的时间
        student.setENROLLMENTYEAR(date);
//        studentDao.insertStu(student);

//        studentDao.updateStu("jjk","2062810126","物联网工程","女",date,"机电工程学院");

        List<Map> students = studentDao.selectAll();
        System.out.println(students);
///////////////////////////////////////////////////////////////////////////
        TeacherDao teacherDao = new TeacherDao(sqlSession);
//        teacherDao.insertTea("2020000004","边钰","女","机电工程学院");
        teacherDao.updateTea("2020000001","边钰","女","机电工程学院");
        List<Map> teachers = teacherDao.selectAll();
        System.out.println(teachers);
////////////////////////////////////////////////////////////////////////////////
//        DeptDao deptDao = new DeptDao(sqlSession);
//        System.out.println(deptDao.selectDnameForDno("商学院"));
///////////////////////////////////////////////////////////////////////////
//        UserDao userDao = new UserDao(sqlSession);
//        userDao.updatePassword("2062810126","jjk");
//        userDao.deleteOne("2062810126");
//        List<Map> users = userDao.selectAll();
//        System.out.println(users.get(0).get("userId"));
        ///////////////////////////////////
//        AdvisorsDao advisorsDao = new AdvisorsDao(sqlSession);
//        List<String> tnos = advisorsDao.selectTnoByTeamno(1);
//        System.out.println(tnos.get(0));
        //关闭sqlSession释放资源
        sqlSession.close();

        System.out.println("结果");
        System.out.println(Integer.valueOf("123"));

    }
}
