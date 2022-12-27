package com.hhu20.jsgl.mapper;

import java.util.List;
import java.util.Map;

public interface BonusRuleMapper {
    public List<Map> selectAll();

    public List<Map> update(String bno, String s_firstprize_amount, String s_secondprize_amount, String s_thirdprize_amount,
                            String s_noprize_amount, String t_firstprize_amount, String t_secondprize_amount, String t_thirdprize_amount,
                            String t_noprize_amount);

    public List<Map> add(String bno, String s_firstprize_amount, String s_secondprize_amount, String s_thirdprize_amount,
                         String s_noprize_amount, String t_firstprize_amount, String t_secondprize_amount, String t_thirdprize_amount,
                         String t_noprize_amount);

    public List<Map> delete(String bno);

    public List<Map> select(String bno);
}
