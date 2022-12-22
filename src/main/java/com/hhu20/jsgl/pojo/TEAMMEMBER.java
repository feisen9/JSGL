package com.hhu20.jsgl.pojo;

public class TEAMMEMBER {
    private String SNO        ;
    private String TEAMNO     ;
    private float  SCOFFICIENT;

    @Override
    public String toString() {
        return "TEAMMEMBER{" +
                "SNO='" + SNO + '\'' +
                ", TEAMNO='" + TEAMNO + '\'' +
                ", SCOFFICIENT=" + SCOFFICIENT +
                '}';
    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getTEAMNO() {
        return TEAMNO;
    }

    public void setTEAMNO(String TEAMNO) {
        this.TEAMNO = TEAMNO;
    }

    public float getSCOFFICIENT() {
        return SCOFFICIENT;
    }

    public void setSCOFFICIENT(float SCOFFICIENT) {
        this.SCOFFICIENT = SCOFFICIENT;
    }
}
