package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.pojo.Student;
import com.hhu20.jsgl.pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    List<Map> selectAll();
    List<Map> selectTNO(String tno);
    void insertTea(Teacher teacher);
    void updateTea(String tname,String tno,String tsex,String dno);
}
