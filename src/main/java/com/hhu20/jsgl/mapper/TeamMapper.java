package com.hhu20.jsgl.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeamMapper {
    List<Map> selectAll();
    int updatePnoandAwardInfo(@Param("teamno") int teamno,@Param("pno") int pno,@Param("awardinfo") String awardinfo);
    void updateAwardAuditResult(@Param("teamno") String teamNo, @Param("awardAuditResult") String awardAuditResult);
}
