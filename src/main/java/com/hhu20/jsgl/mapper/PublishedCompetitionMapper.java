package com.hhu20.jsgl.mapper;

import java.util.List;
import java.util.Map;

public interface PublishedCompetitionMapper {
    List<Map> selectAll();

    List<Map> add(String PNO,String CNO,String PSTATE,String R_INFO_COLLECT_TIME,String A_INFO_COLLECT_TIME,String R_INFO_DEADLINE,String A_INFO_DEADLINE,String SMAXNUM,String TMAXNUM);

    List<Map> delete(String PNO);

    List<Map> update(String PNO,String PSTATE,String pperson, String pyear, String R_INFO_COLLECT_TIME,
                     String A_INFO_COLLECT_TIME,String R_INFO_DEADLINE,String A_INFO_DEADLINE,
                     String SMAXNUM,String TMAXNUM);
    List<Map> selectByCondition(String PNO,String CNO,String PSTATE,String R_INFO_COLLECT_TIME,String A_INFO_COLLECT_TIME,String R_INFO_DEADLINE,String A_INFO_DEADLINE,String SMAXNUM,String TMAXNUM);

}
