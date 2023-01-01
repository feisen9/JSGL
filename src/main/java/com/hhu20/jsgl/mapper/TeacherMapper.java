package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.pojo.Student;
import com.hhu20.jsgl.pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    List<Map> selectAll();
    List<Map> selectTNO(String tno);
    List<Map> select(String tno);
    void insertTea(Teacher teacher);
    void updateTea(@Param("tname") String tname,@Param("tno") String tno,@Param("tsex") String tsex,@Param("dno") String dno);
}
