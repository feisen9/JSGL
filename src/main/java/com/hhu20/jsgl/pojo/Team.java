package com.hhu20.jsgl.pojo;

import java.sql.Date;

public class Team {
    private String TEAMNO        ;
    private String PNO           ;
    private String TEAMNAME      ;
    private Date REGISTERTIME    ;
    private String AWARDINFO     ;
    private String R_AUDIT_RESULT;
    private String A_AUDIT_RESULT;

    @Override
    public String toString() {
        return "Team{" +
                "TEAMNO='" + TEAMNO + '\'' +
                ", PNO='" + PNO + '\'' +
                ", TEAMNAME='" + TEAMNAME + '\'' +
                ", REGISTERTIME=" + REGISTERTIME +
                ", AWARDINFO='" + AWARDINFO + '\'' +
                ", R_AUDIT_RESULT='" + R_AUDIT_RESULT + '\'' +
                ", A_AUDIT_RESULT='" + A_AUDIT_RESULT + '\'' +
                '}';
    }

    public String getTEAMNO() {
        return TEAMNO;
    }

    public void setTEAMNO(String TEAMNO) {
        this.TEAMNO = TEAMNO;
    }

    public String getPNO() {
        return PNO;
    }

    public void setPNO(String PNO) {
        this.PNO = PNO;
    }

    public String getTEAMNAME() {
        return TEAMNAME;
    }

    public void setTEAMNAME(String TEAMNAME) {
        this.TEAMNAME = TEAMNAME;
    }

    public Date getREGISTERTIME() {
        return REGISTERTIME;
    }

    public void setREGISTERTIME(Date REGISTERTIME) {
        this.REGISTERTIME = REGISTERTIME;
    }

    public String getAWARDINFO() {
        return AWARDINFO;
    }

    public void setAWARDINFO(String AWARDINFO) {
        this.AWARDINFO = AWARDINFO;
    }

    public String getR_AUDIT_RESULT() {
        return R_AUDIT_RESULT;
    }

    public void setR_AUDIT_RESULT(String r_AUDIT_RESULT) {
        R_AUDIT_RESULT = r_AUDIT_RESULT;
    }

    public String getA_AUDIT_RESULT() {
        return A_AUDIT_RESULT;
    }

    public void setA_AUDIT_RESULT(String a_AUDIT_RESULT) {
        A_AUDIT_RESULT = a_AUDIT_RESULT;
    }
}
