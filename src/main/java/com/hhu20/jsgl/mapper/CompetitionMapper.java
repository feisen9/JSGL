package com.hhu20.jsgl.mapper;

import java.util.List;
import java.util.Map;

public interface CompetitionMapper {
    List<Map> selectAll();

    List<Map> add(String cno, String cname, String clevel,
            String organizer, String hostinstitue);

//    int add(String cno, String bno, String cname, String clevel,
//                   String organizer, String hostinstitue);
    List<Map> delete(String cno);

    List<Map> update(String cno, String cname, String clevel,
                     String organizer, String hostinstitue);

    List<Map> selectByCondition(String cno, String cname, String clevel,
                     String organizer, String hostinstitue);

}
