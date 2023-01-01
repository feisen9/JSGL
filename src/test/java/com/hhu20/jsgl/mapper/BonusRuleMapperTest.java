package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.dao.BonusRuleDao;
import com.hhu20.jsgl.dao.SqlSessionTool;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.hhu20.jsgl.mapper.PublishedCompetitionMapperTest.printtestlist;

class BonusRuleMapperTest {
    SqlSessionTool sqlSessionTool = new SqlSessionTool();
    SqlSession session = sqlSessionTool.getSqlSession();
    BonusRuleDao bonusRuleDao = new BonusRuleDao(session);

    BonusRuleMapperTest() throws IOException {
    }

    @Test
    void selectAll() {
        List<Map> list = bonusRuleDao.selectAll();
        printtestlist(list);
        session.close();
    }

    @Test
    void update() {
        bonusRuleDao.update("一级竞赛","3600","2500","1500","0","5000","3500","2500","1500","0","5000","3500","2500","1500","0","5000");
        session.close();
    }

    @Test
    void add() {
        int rows = bonusRuleDao.add("一级竞赛","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0");
        System.out.println(rows);
        session.close();
    }

    @Test
    void delete() {
        bonusRuleDao.delete("未认定");
        session.close();
    }

    @Test
    void select() {
        List<Map> list = bonusRuleDao.select("一级竞赛");
        printtestlist(list);
        session.close();
    }
}