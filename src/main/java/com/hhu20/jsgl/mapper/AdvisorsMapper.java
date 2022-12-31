package com.hhu20.jsgl.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdvisorsMapper {

    List<String> selectTnoByTeamno(@Param("teamno") int teamno); //精确查询teamno 把该团队的指导老师的tno返回
    void update(@Param("tcoefficient") float tcoefficient,@Param("tno") String tno,@Param("teamno") int teamno);

}
