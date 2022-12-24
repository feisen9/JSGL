package com.hhu20.jsgl.pojo;

import com.hhu20.jsgl.entity.User;

public class Teacher {
    private String TNO   ;
    private String DNO   ;
    private String TNAME ;
    private String TSEX  ;


    @Override
    public String toString() {
        return "Teacher{" +
                "TNO='" + TNO + '\'' +
                ", DNO='" + DNO + '\'' +
                ", TNAME='" + TNAME + '\'' +
                ", TSEX='" + TSEX + '\'' +
                '}';
    }

    public String getTNO() {
        return TNO;
    }

    public void setTNO(String TNO) {
        this.TNO = TNO;
    }

    public String getDNO() {
        return DNO;
    }

    public void setDNO(String DNO) {
        this.DNO = DNO;
    }

    public String getTNAME() {
        return TNAME;
    }

    public void setTNAME(String TNAME) {
        this.TNAME = TNAME;
    }

    public String getTSEX() {
        return TSEX;
    }

    public void setTSEX(String TSEX) {
        this.TSEX = TSEX;
    }
}
