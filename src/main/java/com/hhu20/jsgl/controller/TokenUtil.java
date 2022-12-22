//package com.hhu20.jsgl.controller;
//
//import java.util.UUID;
//
//public class TokenUtil {
//
//
//    private static Map<String, User> tokenMap = new HashMap<>();
//
//
//    public static String generateToken(User user){
//        //生成唯一不重复的字符串
//        String token = UUID.randomUUID().toString();
//        tokenMap.put(token,user);
//        return token;
//    }
//
//    /**
//     * 验证token是否合法
//     * @param token
//     * @return
//     */
//    public static  boolean verify(String token){
//        return tokenMap.containsKey(token);
//    }
//
//    public static User gentUser(String token){
//        return tokenMap.get(token);
//    }
//
//    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++){
//            System.out.println(UUID.randomUUID().toString());
//        }
//    }
//
//}
