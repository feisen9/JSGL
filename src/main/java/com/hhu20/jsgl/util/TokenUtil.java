package com.hhu20.jsgl.util;

import com.hhu20.jsgl.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

/**
 * 时间令牌
 */
@Component
public class TokenUtil {
    @Autowired
    AuthorizationService authorizationService;
    @Autowired
    RedisUtil cache;
    public TokenUtil(){};

    public Map<String,String> verifyToken(String accessToken){
        Map<String,String> outMap = new TreeMap<>();
        String userId = authorizationService.verifyToken(accessToken);
        if(userId==null){
            String refreshToken = (String) cache.get(accessToken);
            userId = authorizationService.verifyToken(refreshToken);
            if(userId==null){
                //失效了
                outMap.put("userId",null);
                return outMap;
            }
            accessToken = authorizationService.createAccessIdToken(userId);
            refreshToken = authorizationService.createRefreshIdToken(userId);
            cache.del(accessToken);
            cache.set(accessToken,refreshToken,600);//存储,600s
            outMap.put("userId",userId);
            outMap.put("Authorization",accessToken);
            return outMap;
        }
        outMap.put("userId",userId);
        outMap.put("Authorization",accessToken);
        return outMap;
    }

    public String createToken(String userId){
        String accessToken = authorizationService.createAccessIdToken(userId);
        String refreshToken = authorizationService.createRefreshIdToken(userId);
        if(accessToken==null||refreshToken==null){
            return null;
        }
        cache.set(accessToken,refreshToken,600);//存储,600s
        return accessToken;
    }


}