package com.hhu20.jsgl.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionTool {
    SqlSession sqlSession;
    public SqlSessionTool() throws IOException {
        //1、加载mybatis核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象，用它来执行sql
        sqlSession = sqlSessionFactory.openSession(true);
    }
    public SqlSession getSqlSession(){
        return this.sqlSession;
    }
    public void close(){
        this.sqlSession.close();
    }
}
