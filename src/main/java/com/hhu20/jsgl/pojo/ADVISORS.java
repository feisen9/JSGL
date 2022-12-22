package com.hhu20.jsgl.pojo;

public class ADVISORS {
    private String TNO         ;
    private String TEAMNO      ;
    private String TCOEFFICIENT;

    public String getTNO() {
        return TNO;
    }

    public void setTNO(String TNO) {
        this.TNO = TNO;
    }

    public String getTEAMNO() {
        return TEAMNO;
    }

    public void setTEAMNO(String TEAMNO) {
        this.TEAMNO = TEAMNO;
    }

    public String getTCOEFFICIENT() {
        return TCOEFFICIENT;
    }

    public void setTCOEFFICIENT(String TCOEFFICIENT) {
        this.TCOEFFICIENT = TCOEFFICIENT;
    }

    @Override
    public String toString() {
        return "ADVISORS{" +
                "TNO='" + TNO + '\'' +
                ", TEAMNO='" + TEAMNO + '\'' +
                ", TCOEFFICIENT='" + TCOEFFICIENT + '\'' +
                '}';
    }
}
