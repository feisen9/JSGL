package com.hhu20.jsgl.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BonusMapper {

    List<Map> selectAllTeaBonus();
    List<Map> selectAllStuBonus();
    List<Map> searchBonus(@Param("sno") String sno,@Param("tno") String tno, @Param("pno") Integer pno);

}
