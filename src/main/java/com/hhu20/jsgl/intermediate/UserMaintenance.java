package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.SqlSessionTool;
import com.hhu20.jsgl.dao.StudentDao;
import com.hhu20.jsgl.dao.TeacherDao;
import com.hhu20.jsgl.pojo.Student;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserMaintenance {
    public static List<Map> getStuInfoById(String sno, boolean all){
        List<Map> students;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            StudentDao studentDao = new StudentDao(sqlSession);
            if(all==true) {
                students = studentDao.selectAll();
            }else{
                students = studentDao.select(sno);
            }
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static List<Map> getTeaInfoById(String tno, boolean all){
        List<Map> teachers;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            TeacherDao teacherDao = new TeacherDao(sqlSession);
            if(all==true) {
                teachers = teacherDao.selectAll();
            }else{
                teachers = teacherDao.select(tno);
            }
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }
}
