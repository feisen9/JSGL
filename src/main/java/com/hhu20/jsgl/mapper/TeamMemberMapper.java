package com.hhu20.jsgl.mapper;

import org.apache.ibatis.annotations.Param;

public interface TeamMemberMapper {
    void updateTeammembers(@Param("scofficient") float scofficient, @Param("sno") String sno, @Param(("teamno")) int teamno);

}
