package com.hhu20.jsgl.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeamMemberMapper {
    void updateTeammembers(@Param("scofficient") float scofficient, @Param("sno") String sno, @Param(("teamno")) int teamno);
    List<Map> selectByTeamno(@Param("teamno") int teamno);
}
