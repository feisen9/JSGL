package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.SqlSessionTool;
import com.hhu20.jsgl.dao.StudentDao;
import com.hhu20.jsgl.dao.TeacherDao;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Date;
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

    public static void stuUpdate(String sname, String sno, String major, String sex,
                                 Date enrollmentYear, String academy){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            StudentDao studentDao = new StudentDao(sqlSession);
            studentDao.updateStu(sname,sno,major,sex,enrollmentYear,academy);
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int addStu(String sname, String sno, String major, String sex,
                             String enrollmentYear, String academy){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            StudentDao studentDao = new StudentDao(sqlSession);
            int rows = studentDao.insertStu(sname,sno,major,sex,enrollmentYear,academy);
            if(rows!=1)
                throw new RuntimeException("插入学生时出现未知错误，请联系系统管理员");
            sqlSession.close();
            return  rows;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int addTea(String tno,String tname, String sex, String academy){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            TeacherDao teacherDao = new TeacherDao(sqlSession);
            int rows = teacherDao.insertTea(tno,tname,sex,academy);
            if(rows!=1)
                throw new RuntimeException("插入学生时出现未知错误，请联系系统管理员");
            sqlSession.close();
            return  rows;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
