package com.hhu20.jsgl.intermediate;

import com.hhu20.jsgl.dao.SqlSessionTool;
import com.hhu20.jsgl.dao.StudentDao;
import com.hhu20.jsgl.dao.TeacherDao;

import com.hhu20.jsgl.dao.UserDao;
import com.hhu20.jsgl.pojo.Student;

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
                                 String enrollmentYear, String academy){
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
                throw new RuntimeException("????????????????????????????????????????????????????????????");
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
                throw new RuntimeException("????????????????????????????????????????????????????????????");
            sqlSession.close();
            return  rows;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static void teaUpdate(String tname, String tno,String sex, String academy){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            TeacherDao teacherDao = new TeacherDao(sqlSession);
            teacherDao.updateTea(tno,tname,sex,academy);
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void stuAdd(String sname, String sno, String major, String sex, Date enrollmentYear, String academy){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            StudentDao studentDao = new StudentDao(sqlSession);
            Student student = new Student();

            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void teaAdd(String tname, String tno,String sex, String academy){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            TeacherDao teacherDao = new TeacherDao(sqlSession);

            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void userUpdate(String userId, String password){
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            UserDao userDao = new UserDao(sqlSession);
            userDao.updatePassword(userId, password);
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int deleteStu(String sno){
        int r = 0;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            StudentDao studentDao = new StudentDao(sqlSession);
            r = studentDao.deleteOne(sno);
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return r;
    }

    public static int deleteTea(String tno){
        int r = 0;
        try {
            SqlSessionTool sqlSessionTool = new SqlSessionTool();
            SqlSession sqlSession = sqlSessionTool.getSqlSession();
            TeacherDao teacherDao = new TeacherDao(sqlSession);
            r = teacherDao.deleteOne(tno);
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return r;
    }

}

