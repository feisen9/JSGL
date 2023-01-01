package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.dao.*;
import com.hhu20.jsgl.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    SqlSessionTool sqlSessionTool = new SqlSessionTool();
    SqlSession session = sqlSessionTool.getSqlSession();
    StudentDao studentDao = new StudentDao(session);
    TeacherDao teacherDao = new TeacherDao(session);
    UserDao userDao = new UserDao(session);

    StudentMapperTest() throws IOException {
    }

//    @Test
//    void insertStu() throws Exception {
//        int rows = studentDao.insertStu("里斯","2062810301","计算机科学与技术","男","2020-09-19","物联网工程学院");
//        System.out.println(rows);
//        session.close();
//    }
//    @Test
//    void insertTea() throws Exception {
//        int rows = teacherDao.insertTea("2020000020","里斯","男","物联网工程学院");
//        System.out.println(rows);
//        session.close();
//    }
    @Test
    void reg() throws Exception {
        userDao.deleteOne("2062810101");
        User user = new User();
        user.setUserId("2062810101");
        user.setPassword("12345");
//        Map<String,String> map = userDao.add("2062810101","12345");
       userDao.add(user);
        System.out.println(user.getUserType());
        session.close();
    }
}