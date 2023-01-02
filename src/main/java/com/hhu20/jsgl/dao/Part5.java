package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.Part5Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Part5 {
    private SqlSession sqlSession;
    private Part5Mapper part5Mapper;
    public Part5(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        part5Mapper = sqlSession.getMapper(Part5Mapper.class);
    }

    public List<Map> checkTeam(String teamno){
        return part5Mapper.checkTeam(teamno);
    }
    public void  updateTeam(String teamno, String  pno, String teamname){
        part5Mapper.updateTeam(teamno,pno,teamname);
    }
    public void  deleteStuTea(String teamno){
        part5Mapper.deleteStuTea(teamno);
    }

    public List<Map> teamSelectN(String teamno, String pno, String teamname, String registertime, String r_audit_result,
                                 String a_audit_result){
        if (teamno!=null &&teamno.equals("")){teamno = null;}
        if (pno!=null &&pno.equals("")){pno = null;}
        if (teamname!=null &&teamname.equals("")){teamname = null;}
        if (registertime!=null &&registertime.equals("")){registertime = null;}
        if (r_audit_result!=null &&r_audit_result.equals("")){r_audit_result = null;}
        if (a_audit_result!=null &&a_audit_result.equals("")){a_audit_result = null;}
        return part5Mapper.teamSelectN(teamno,pno,teamname,registertime,r_audit_result,a_audit_result);
    }

    public void teamInsert(String teamname, String pno, String registertime){
        part5Mapper.teamInsert(teamname,pno,registertime);
    }

    public void teammemberInsert(String sno, String teamno){
        part5Mapper.teammemberInsert(sno,teamno);
    }

    public void advisorInsert(String tno, String teamno){
        part5Mapper.advisorInsert(tno, teamno);
    }

    public void deleteTeam(String teamno){
        part5Mapper.deleteTeam(teamno);
    }

    public void updateTeamR(String teamno, String r_audit_result){
        part5Mapper.updateTeamR(teamno,r_audit_result);
    }

    public List<Map> advisorSelectN(String teamno, String tno){
        return part5Mapper.advisorSelectN(tno, teamno);
    }

    public List<Map> teammemberSelectN(String sno, String teamno){
        return part5Mapper.teammemberSelectN(sno,teamno);
    }
    public List<Map> selectTeamCT(String pno, String cname, String sno, String sname,
                           String tno, String tname , String regAuditResult){
        if (pno!=null &&pno.equals("")){pno = null;}
        if (cname!=null &&cname.equals("")){cname = null;}
        if (sno!=null &&sno.equals("")){sno = null;}
        if (sname!=null &&sname.equals("")){sname = null;}
        if (tno!=null &&tno.equals("")){tno = null;}
        if (tname!=null &&tname.equals("")){tname = null;}
        if (regAuditResult!=null &&regAuditResult.equals("")){regAuditResult = null;}
        return part5Mapper.selectTeamCT(pno,cname,sno,sname,tno,tname,regAuditResult);
    }

    public List<Map> selectTStu(String teamno){
        return part5Mapper.selectTStu(teamno);
    }

    public List<Map> selectTTea(String teamno){
        return part5Mapper.selectTTea(teamno);
    }
}
