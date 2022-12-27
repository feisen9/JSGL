package com.hhu20.jsgl.mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class CompetitionMapperTest {

    @Test
    public void test() throws IOException {

        String mybatisConfigFilePath = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sessionFactory.openSession();

        CompetitionMapper competitionMapper = session.getMapper(CompetitionMapper.class);


//        String statement = "com.hhu20.jsgl.mapper.CompetitionMapper.selectAll";
//
//        List<Map>  list = session.selectList(statement);
//
//        for(int i = 0;i<list.size();i++){
//            Map<String, Object> map = list.get(i);
//            Iterator it = map.keySet().iterator();
//            while (it.hasNext()) {
//                String str = (String) it.next();
//                System.out.print(str+": ");
//                System.out.print(map.get(str)+"\t  ");
//            }
//            System.out.println();
//        }
//
//        String cno = "c0024";
//        String bno = "b0001";
//        String cname = "fwwb";
//        String clevel = "一级竞赛";
//        String organizer = "中国科协";
//        String hostintitue = "教务处";

//        List<Map> result = competitionMapper.add(cno,bno,cname,clevel,organizer,hostintitue);
//        System.out.println("result = " + result);

//        List<Map> result = competitionMapper.delete(cno);
//        System.out.println("result = " + result);

//        String newcname = "服务外包";
//        List<Map> result2 = competitionMapper.update(cno,bno,newcname,clevel,organizer,hostintitue);
//        System.out.println("result = " + result2);


//        String cno = "";
//        String bno = "";
//        String organizer = "";
//        String hostintitue = "";
//        String search_cname = "科技";
//        String search_clevel = "一级竞赛";
//
//        List<Map> list = competitionMapper.selectByCondition(cno,bno,search_cname,search_clevel,organizer,hostintitue);
//        for(int i = 0;i<list.size();i++){
//            Map<String, Object> map = list.get(i);
//            Iterator it = map.keySet().iterator();
//            while (it.hasNext()) {
//                String str = (String) it.next();
//                System.out.print(str+": ");
//                System.out.print(map.get(str)+"\t  ");
//            }
//            System.out.println();
//        }

        session.close();
    }
}