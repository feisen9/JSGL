package com.hhu20.jsgl.utils;

public class FuzzyQueryStr {
    //该类的静态方法用于调用数据库查询时模糊查询的字符串转换
    public static String unilateralFuzzy(String str){
        //单侧模糊查询
        if (str==null){
            return null;
        }
        else
            return str+"%";
    }
    public static String bilateralFuzzy(String str){
        //双侧模糊查询
        if(str == null) return null;
        else return "%"+str+"%";
    }
}
