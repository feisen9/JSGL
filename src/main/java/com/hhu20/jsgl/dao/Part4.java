package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.Part4Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class Part4 {
    private SqlSession sqlSession;
    private Part4Mapper part4Mapper;
    public Part4(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        part4Mapper = sqlSession.getMapper(Part4Mapper.class);
    }

    public List<Map> selectAllPC(){
        return part4Mapper.selectAllPC();
    }

    public List<Map>  selectPC(String pno, String cname, String pstate, String pperson, String pyear,
                        String r_info_collect_time,String a_info_collect_time,
                        String r_info_deadline ,String a_info_deadline ,String smaxnum, String tmaxnum){
        if (pno!=null &&pno.equals("")){pno = null;}
        if ( cname!=null && cname.equals("")){ cname = null;}
        if ( pstate!=null && pstate.equals("")){ pstate = null;}
        if ( pperson!=null && pperson.equals("")){ pperson = null;}
        if ( pyear!=null && pyear.equals("")){ pyear = null;}
        if ( r_info_collect_time!=null && r_info_collect_time.equals("")){ r_info_collect_time = null;}
        if ( a_info_collect_time!=null && a_info_collect_time.equals("")){ a_info_collect_time = null;}
        if ( r_info_deadline !=null && r_info_deadline .equals("")){ r_info_deadline  = null;}
        if ( a_info_deadline!=null && a_info_deadline.equals("")){ a_info_deadline = null;}
        if ( smaxnum!=null && smaxnum.equals("")){ smaxnum = null;}
        if ( tmaxnum!=null && tmaxnum.equals("")){ tmaxnum = null;}
        return part4Mapper.selectPC(pno, cname, pstate, pperson, pyear, r_info_collect_time, a_info_collect_time,
                r_info_deadline , a_info_deadline, smaxnum, tmaxnum);
    }

    public void insertP(String cno, String pstate, String pperson, String  pyear, String r_info_collect_time,
                       String a_info_collect_time, String r_info_deadline , String a_info_deadline,
                       String smaxnum, String tmaxnum){
        if (cno!=null &&cno.equals("")){cno = null;}
        if ( pstate!=null && pstate.equals("")){ pstate = null;}
        if ( pperson!=null && pperson.equals("")){ pperson = null;}
        if ( pyear!=null && pyear.equals("")){ pyear = null;}
        if ( r_info_collect_time!=null && r_info_collect_time.equals("")){ r_info_collect_time = null;}
        if ( a_info_collect_time!=null && a_info_collect_time.equals("")){ a_info_collect_time = null;}
        if ( r_info_deadline !=null && r_info_deadline .equals("")){ r_info_deadline  = null;}
        if ( a_info_deadline!=null && a_info_deadline.equals("")){ a_info_deadline = null;}
        if ( smaxnum!=null && smaxnum.equals("")){ smaxnum = null;}
        if ( tmaxnum!=null && tmaxnum.equals("")){ tmaxnum = null;}
        part4Mapper.insertP(cno, pstate, pperson, pyear, r_info_collect_time, a_info_collect_time,
                r_info_deadline , a_info_deadline, smaxnum, tmaxnum);
    }

}
