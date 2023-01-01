package com.hhu20.jsgl.mapper;

import java.util.List;
import java.util.Map;

public interface BonusRuleMapper {
    public List<Map> selectAll();

    public List<Map> update(String clevel, String stu_1, String stu_2, String stu_3,
                            String stu_no, String stu_t,  String tea_1, String tea_2, String tea_3,
                            String tea_no, String tea_t,String team_1, String team_2, String team_3,
                            String team_no, String team_t);
    public int add(String clevel, String stu_1, String stu_2, String stu_3,
                         String stu_no, String stu_t, String tea_1, String tea_2, String tea_3,
                         String tea_no, String tea_t, String team_1, String team_2, String team_3,
                         String team_no, String team_t);
    public List<Map> delete(String clevel);

    public List<Map> select(String clevel);
}
