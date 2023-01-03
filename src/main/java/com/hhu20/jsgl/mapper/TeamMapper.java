package com.hhu20.jsgl.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeamMapper {
    List<Map> selectAll();
    int addPnoandAwardInfo(@Param("teamno") Integer teamno,@Param("pno") Integer pno,@Param("awardinfo") String awardinfo);
    int updatePnoandAwardInfo(@Param("teamno") Integer teamno,@Param("pno") Integer pno,@Param("awardinfo") String awardinfo);
    int updateAwardAuditResult(@Param("teamno") String teamNo, @Param("awardAuditResult") String awardAuditResult);
}
