package com.hhu20.jsgl.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AwardMapper {
    List<Map> searchAward(@Param("pno") int pno, @Param("cname")String cname, @Param("awardInfo")String awardInfo,
                          @Param("sno")String sno, @Param("sname")String sname, @Param("tno")String tno,
                          @Param("tname")String tname, @Param("awardAuditResult")String awardAuditResult);
    List<Map> getAwardInfo();
    int deleteAwardInfo(@Param("teamno") int teamno);
}
