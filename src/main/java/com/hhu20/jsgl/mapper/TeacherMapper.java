package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> selectAll();
    List<Teacher> selectTNO(String tno);
}
