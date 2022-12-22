package com.hhu20.jsgl.pojo;

public class Dept {
    private String DNO  ;
    private String DNAME;

    @Override
    public String toString() {
        return "Dept{" +
                "DNO='" + DNO + '\'' +
                ", DNAME='" + DNAME + '\'' +
                '}';
    }

    public String getDNO() {
        return DNO;
    }

    public void setDNO(String DNO) {
        this.DNO = DNO;
    }

    public String getDNAME() {
        return DNAME;
    }

    public void setDNAME(String DNAME) {
        this.DNAME = DNAME;
    }
}
