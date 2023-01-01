package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.dao.PublishedCompetitionDao;
import com.hhu20.jsgl.dao.SqlSessionTool;
import com.hhu20.jsgl.dao.StudentDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PublishedCompetitionMapperTest {
    SqlSessionTool sqlSessionTool = new SqlSessionTool();
    SqlSession session = sqlSessionTool.getSqlSession();
    PublishedCompetitionDao publishedCompetitionDao = new PublishedCompetitionDao(session);

    PublishedCompetitionMapperTest() throws IOException {
    }

    @Test
    void selectAll() throws IOException {
        List<Map> list = publishedCompetitionDao.selectAll();
        printtestlist(list);
        session.close();
    }

    @Test
    void add() throws IOException {
        List<Map> list = publishedCompetitionDao.add("p0004","c0001","报名结束","2022-9-10","2022-9-10","2022-9-10","2022-9-10","5","3");
        session.close();
    }


    @Test
    void delete() {
        List<Map> list = publishedCompetitionDao.delete("p0004");
        session.close();
    }

    @Test
    void update() {
        List<Map> list = publishedCompetitionDao.update("p0003","c0001","获奖收集中","2022-9-10","2022-10-10","2022-9-10","2022-10-10","5","3");
        session.close();
    }

    @Test
    void selectByCondition() {
        List<Map> list = publishedCompetitionDao.selectByCondition("","","报名结束","2022-8-10","2022-8-10","2022-10-10","2022-10-10","5","3");
        printtestlist(list);
        session.close();
    }

    public static void printtestlist(List<Map> list ){
        for(int i = 0;i<list.size();i++){
            Map<String, Object> map = list.get(i);
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                System.out.print(str+": ");
                System.out.print(map.get(str)+"\t  ");
            }
            System.out.println();
        }
    }


}