package com.hhu20.jsgl.dao;

import com.hhu20.jsgl.mapper.AdvisorsMapper;
import com.hhu20.jsgl.mapper.BonusRuleMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class AdvisorsDao {
    private SqlSession sqlSession;
    private AdvisorsMapper advisorsMapper;
    public AdvisorsDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        advisorsMapper = sqlSession.getMapper(AdvisorsMapper.class);
    }
    public List<String> selectTnoByTeamno(int teamno){
        /*
        selectTnoByTeamno
        description:传入teamno返回该团队所有指导老师的tno以String列表形式返回
        param: teamno
        return: List<String> tnomap
         */
        return advisorsMapper.selectTnoByTeamno(teamno);
    }
    public void update(List<Map> advisors, Integer teamno) throws Exception{
        for (Map advisor:advisors){
            advisorsMapper.update((Float) advisor.get("soefficient"), (String) advisor.get("tno"),teamno);
        }
    }
    public List<Map> selectByTeamno(int teamno){ //根据teamno查tno,tname,tcoefficient
        List<Map> outMap = advisorsMapper.selectByTeamno(teamno);
        //改变键名与前端对应
        for(int i=0;i<outMap.size();i++){
            float sofficient = (float) outMap.get(i).get("tcoefficient");
            outMap.get(0).remove("tcoefficient");
            outMap.get(0).put("sofficient",sofficient);
        }
        return outMap;
    }



}
