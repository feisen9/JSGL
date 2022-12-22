package com.hhu20.jsgl.pojo;

import java.sql.Date;

public class PublishedCompetition {
    private String PNO           ;
    private String CNO           ;
    private String PSTATE        ;
    private Date R_INFO_COLLECT_TIME;
    private Date A_INFO_COLLECT_TIME;
    private Date R_INFO_DEADLINE    ;
    private Date A_INFO_DEADLINE    ;
    private Integer SMAXNUM         ;
    private Integer TMAXNUM         ;

    @Override
    public String toString() {
        return "PublishedCompetition{" +
                "PNO='" + PNO + '\'' +
                ", CNO='" + CNO + '\'' +
                ", PSTATE='" + PSTATE + '\'' +
                ", R_INFO_COLLECT_TIME=" + R_INFO_COLLECT_TIME +
                ", A_INFO_COLLECT_TIME=" + A_INFO_COLLECT_TIME +
                ", R_INFO_DEADLINE=" + R_INFO_DEADLINE +
                ", A_INFO_DEADLINE=" + A_INFO_DEADLINE +
                ", SMAXNUM=" + SMAXNUM +
                ", TMAXNUM=" + TMAXNUM +
                '}';
    }

    public String getPNO() {
        return PNO;
    }

    public void setPNO(String PNO) {
        this.PNO = PNO;
    }

    public String getCNO() {
        return CNO;
    }

    public void setCNO(String CNO) {
        this.CNO = CNO;
    }

    public String getPSTATE() {
        return PSTATE;
    }

    public void setPSTATE(String PSTATE) {
        this.PSTATE = PSTATE;
    }

    public Date getR_INFO_COLLECT_TIME() {
        return R_INFO_COLLECT_TIME;
    }

    public void setR_INFO_COLLECT_TIME(Date r_INFO_COLLECT_TIME) {
        R_INFO_COLLECT_TIME = r_INFO_COLLECT_TIME;
    }

    public Date getA_INFO_COLLECT_TIME() {
        return A_INFO_COLLECT_TIME;
    }

    public void setA_INFO_COLLECT_TIME(Date a_INFO_COLLECT_TIME) {
        A_INFO_COLLECT_TIME = a_INFO_COLLECT_TIME;
    }

    public Date getR_INFO_DEADLINE() {
        return R_INFO_DEADLINE;
    }

    public void setR_INFO_DEADLINE(Date r_INFO_DEADLINE) {
        R_INFO_DEADLINE = r_INFO_DEADLINE;
    }

    public Date getA_INFO_DEADLINE() {
        return A_INFO_DEADLINE;
    }

    public void setA_INFO_DEADLINE(Date a_INFO_DEADLINE) {
        A_INFO_DEADLINE = a_INFO_DEADLINE;
    }

    public Integer getSMAXNUM() {
        return SMAXNUM;
    }

    public void setSMAXNUM(Integer SMAXNUM) {
        this.SMAXNUM = SMAXNUM;
    }

    public Integer getTMAXNUM() {
        return TMAXNUM;
    }

    public void setTMAXNUM(Integer TMAXNUM) {
        this.TMAXNUM = TMAXNUM;
    }

    public static void main(String args[]) {
        System.out.println("Hello World!");
    }
}
