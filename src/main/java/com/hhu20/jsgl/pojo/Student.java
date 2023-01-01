package com.hhu20.jsgl.pojo;

import java.util.Date;

public class Student {
    private String SNO         ;
    private String MNO         ;
    private String SNAME       ;
    private String SSEX        ;
    private Date ENROLLMENTYEAR;
    private String ACADEMY         ;
    private String MAJOR         ;

    @Override
    public String toString() {
        return "Student{" +
                "SNO='" + SNO + '\'' +
                ", MNO='" + MNO + '\'' +
                ", SNAME='" + SNAME + '\'' +
                ", SSEX='" + SSEX + '\'' +
                ", ENROLLMENTYEAR=" + ENROLLMENTYEAR +
                ", ACADEMY=" + ACADEMY +
                ", MAJOR=" + MAJOR +
                '}';
    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getMNO() {
        return MNO;
    }

    public void setMNO(String MNO) {
        this.MNO = MNO;
    }

    public String getSNAME() {
        return SNAME;
    }

    public void setSNAME(String SNAME) {
        this.SNAME = SNAME;
    }

    public String getSSEX() {
        return SSEX;
    }

    public void setSSEX(String SSEX) {
        this.SSEX = SSEX;
    }

    public Date getENROLLMENTYEAR() {
        return ENROLLMENTYEAR;
    }

    public void setENROLLMENTYEAR(Date ENROLLMENTYEAR) {
        this.ENROLLMENTYEAR = ENROLLMENTYEAR;
    }

    public String getACADEMY() {
        return ACADEMY;
    }

    public void setACADEMY(String ACADEMY) {
        this.ACADEMY = ACADEMY;
    }

    public String getMAJOR() {
        return MAJOR;
    }

    public void setMAJOR(String MAJOR) {
        this.MAJOR = MAJOR;
    }
}
