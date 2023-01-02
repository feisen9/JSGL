package com.hhu20.jsgl.mapper;

import java.util.List;
import java.util.Map;

public interface Part4Mapper {

    List<Map> selectAllPC();

    List<Map>  selectPC(String pno, String cname, String pstate, String pperson, String pyear,
                        String r_info_collect_time,String a_info_collect_time,
                        String r_info_deadline ,String a_info_deadline ,String smaxnum, String tmaxnum);

    void insertP(String cno, String pstate, String pperson, String  pyear, String r_info_collect_time,
                 String a_info_collect_time, String r_info_deadline , String a_info_deadline,
                 String smaxnum, String tmaxnum);
}
