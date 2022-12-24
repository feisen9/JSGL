package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> selectAll();
    List<Student> selectSNO(String SNO);

//    条件查询
    List<Student> selectByCondition(@Param("sno") String sno, @Param("mno") String mno, @Param("sname") String sname, @Param("ssex") String ssex);
}

