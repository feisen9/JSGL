package com.hhu20.jsgl.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Part5Mapper {

    List<Map> checkTeam(String teamno);
    void  updateTeam(String teamno, String  pno, String teamname);
    void  deleteStuTea(String teamno);
    void teamInsert(String teamname, String pno, String registertime);

    void teammemberInsert(String sno, String teamno);

    void advisorInsert(String tno, String teamno);

    List<Map> teamSelectN(String teamno, String pno, String teamname, String registertime, String r_audit_result,
                          String a_audit_result);

    void deleteTeam(String teamno);

    void updateTeamR(String teamno, String r_audit_result);

    List<Map> teammemberSelectN(String sno, String teamno);

    List<Map> advisorSelectN(String tno, String teamno);

    List<Map> selectTeamCT(String pno, String cname, String sno, String sname,
                           String tno, String tname , String regAuditResult);

    List<Map> selectTStu(String teamno);

    List<Map> selectTTea(String teamno);

}
