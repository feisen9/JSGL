package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.dao.BonusRuleDao;
import com.hhu20.jsgl.dao.SqlSessionTool;
import com.hhu20.jsgl.dao.StudentDao;
import com.hhu20.jsgl.dao.TeacherDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    SqlSessionTool sqlSessionTool = new SqlSessionTool();
    SqlSession session = sqlSessionTool.getSqlSession();
    StudentDao studentDao = new StudentDao(session);
    TeacherDao teacherDao = new TeacherDao(session);

    StudentMapperTest() throws IOException {
    }

//    @Test
//    void insertStu() throws Exception {
//        int rows = studentDao.insertStu("里斯","2062810301","计算机科学与技术","男","2020-09-19","物联网工程学院");
//        System.out.println(rows);
//        session.close();
//    }
    @Test
    void insertTea() throws Exception {
        int rows = teacherDao.insertTea("2020000020","里斯","男","物联网工程学院");
        System.out.println(rows);
        session.close();
    }
}