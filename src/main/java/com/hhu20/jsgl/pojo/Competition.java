package com.hhu20.jsgl.pojo;

public class Competition {
    String CNO         ;        //
    String BNO         ;
    String CNAME       ;
    String CLEVEL      ;
    String ORGANIZER   ;
    String HOSTINSTITUE;

    @Override
    public String toString() {
        return "Competition{" +
                "CNO='" + CNO + '\'' +
                ", BNO='" + BNO + '\'' +
                ", CNAME='" + CNAME + '\'' +
                ", CLEVEL='" + CLEVEL + '\'' +
                ", ORGANIZER='" + ORGANIZER + '\'' +
                ", HOSTINSTITUE='" + HOSTINSTITUE + '\'' +
                '}';
    }

    public String getCNO() {
        return CNO;
    }

    public void setCNO(String CNO) {
        this.CNO = CNO;
    }

    public String getBNO() {
        return BNO;
    }

    public void setBNO(String BNO) {
        this.BNO = BNO;
    }

    public String getCNAME() {
        return CNAME;
    }

    public void setCNAME(String CNAME) {
        this.CNAME = CNAME;
    }

    public String getCLEVEL() {
        return CLEVEL;
    }

    public void setCLEVEL(String CLEVEL) {
        this.CLEVEL = CLEVEL;
    }

    public String getORGANIZER() {
        return ORGANIZER;
    }

    public void setORGANIZER(String ORGANIZER) {
        this.ORGANIZER = ORGANIZER;
    }

    public String getHOSTINSTITUE() {
        return HOSTINSTITUE;
    }

    public void setHOSTINSTITUE(String HOSTINSTITUE) {
        this.HOSTINSTITUE = HOSTINSTITUE;
    }
}
