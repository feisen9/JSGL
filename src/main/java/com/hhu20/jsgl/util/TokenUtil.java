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

    public String verifyToken(String token){
        String accessToken = (String) cache.get(token);
        if(accessToken==null){
            cache.del(token);
            return null;
        }
        Map<String,String> map = verifyAccessToken(accessToken);
        String userId = map.get("userId");
        String aToken = map.get("Authorization");
        if(userId==null){
            cache.del(token);
            return null;
        }
        cache.del(token);
        cache.set(token,aToken);
        return userId;
    }

    public Map<String,String> verifyAccessToken(String accessToken){
        Map<String,String> outMap = new TreeMap<>();
        String userId = authorizationService.verifyToken(accessToken);
        if(userId==null){
            String refreshToken = (String) cache.get(accessToken);
            userId = authorizationService.verifyToken(refreshToken);
            if(userId==null){
                //失效了
                cache.del(accessToken);
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
        String token = accessToken.toString();
        if(accessToken==null||refreshToken==null){
            return null;
        }
        cache.set(accessToken,refreshToken,600);//存储,600s
        cache.set(token,accessToken,600);
        return token;
    }


}