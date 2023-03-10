package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {

    List<Map> selectAll();
    List<Map> selectSNO(String SNO);

    List<Map> select(String SNO);

//    条件查询
    List<Map> selectByCondition(@Param("sno") String sno, @Param("mno") String mno,
                                    @Param("sname") String sname, @Param("ssex") String ssex);

    int insertStu(String SNAME, String SNO , String MAJOR, String SSEX ,
                  String ENROLLMENTYEAR , String ACADEMY);

    void updateStu(@Param("sno") String sno,
                   @Param("mno") String mno,
                   @Param("sname") String sname,
                   @Param("ssex") String ssex,
                   @Param("enrollmentyear") String enrollmentyear);

    int deleteOne(String sno);
}

