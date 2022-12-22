package com.hhu20.jsgl.pojo;

public class Major {
    private String MNO ;
    private String DNO ;
    private String MNAME;

    public String getMNO() {
        return MNO;
    }

    public void setMNO(String MNO) {
        this.MNO = MNO;
    }

    public String getDNO() {
        return DNO;
    }

    public void setDNO(String DNO) {
        this.DNO = DNO;
    }

    public String getMNAME() {
        return MNAME;
    }

    public void setMNAME(String MNAME) {
        this.MNAME = MNAME;
    }

    @Override
    public String toString() {
        return "Major{" +
                "MNO='" + MNO + '\'' +
                ", DNO='" + DNO + '\'' +
                ", MNAME='" + MNAME + '\'' +
                '}';
    }
}
