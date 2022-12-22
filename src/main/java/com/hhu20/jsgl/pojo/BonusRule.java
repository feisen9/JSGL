package com.hhu20.jsgl.pojo;

public class BonusRule {
    private float S_FIRSTPRIZE_AMOUNT  ;    //学生获得一等奖的奖金
    private float S_SECONDPRIZE_AMOUNT ;    //学生获得二等奖的奖金
    private float S_THIRDPRIZE_AMOUNT  ;    //学生获得三等奖奖金
    private float S_NOPRIZE_AWARD      ;    //学生不获奖奖金
    private float T_FIRSTPRIZE_AMOUNT  ;    //老师获得一等奖的奖金
    private float T_SECONDPRIZE_AMOUNT ;    //老师获得二等奖的奖金
    private float T_THIRDPRIZE_AMOUNT  ;    //老师获得三等奖奖金
    private float T_NOPRIZE_AMOUNT     ;    //老师不获奖奖金
    private String BNO                ;     //奖金规则编号

    @Override
    public String toString() {
        return "BonusRule{" +
                "S_FIRSTPRIZE_AMOUNT=" + S_FIRSTPRIZE_AMOUNT +
                ", S_SECONDPRIZE_AMOUNT=" + S_SECONDPRIZE_AMOUNT +
                ", S_THIRDPRIZE_AMOUNT=" + S_THIRDPRIZE_AMOUNT +
                ", S_NOPRIZE_AWARD=" + S_NOPRIZE_AWARD +
                ", T_FIRSTPRIZE_AMOUNT=" + T_FIRSTPRIZE_AMOUNT +
                ", T_SECONDPRIZE_AMOUNT=" + T_SECONDPRIZE_AMOUNT +
                ", T_THIRDPRIZE_AMOUNT=" + T_THIRDPRIZE_AMOUNT +
                ", T_NOPRIZE_AMOUNT=" + T_NOPRIZE_AMOUNT +
                ", BNO='" + BNO + '\'' +
                '}';
    }

    public float getS_FIRSTPRIZE_AMOUNT() {
        return S_FIRSTPRIZE_AMOUNT;
    }

    public void setS_FIRSTPRIZE_AMOUNT(float s_FIRSTPRIZE_AMOUNT) {
        S_FIRSTPRIZE_AMOUNT = s_FIRSTPRIZE_AMOUNT;
    }

    public float getS_SECONDPRIZE_AMOUNT() {
        return S_SECONDPRIZE_AMOUNT;
    }

    public void setS_SECONDPRIZE_AMOUNT(float s_SECONDPRIZE_AMOUNT) {
        S_SECONDPRIZE_AMOUNT = s_SECONDPRIZE_AMOUNT;
    }

    public float getS_THIRDPRIZE_AMOUNT() {
        return S_THIRDPRIZE_AMOUNT;
    }

    public void setS_THIRDPRIZE_AMOUNT(float s_THIRDPRIZE_AMOUNT) {
        S_THIRDPRIZE_AMOUNT = s_THIRDPRIZE_AMOUNT;
    }

    public float getS_NOPRIZE_AWARD() {
        return S_NOPRIZE_AWARD;
    }

    public void setS_NOPRIZE_AWARD(float s_NOPRIZE_AWARD) {
        S_NOPRIZE_AWARD = s_NOPRIZE_AWARD;
    }

    public float getT_FIRSTPRIZE_AMOUNT() {
        return T_FIRSTPRIZE_AMOUNT;
    }

    public void setT_FIRSTPRIZE_AMOUNT(float t_FIRSTPRIZE_AMOUNT) {
        T_FIRSTPRIZE_AMOUNT = t_FIRSTPRIZE_AMOUNT;
    }

    public float getT_SECONDPRIZE_AMOUNT() {
        return T_SECONDPRIZE_AMOUNT;
    }

    public void setT_SECONDPRIZE_AMOUNT(float t_SECONDPRIZE_AMOUNT) {
        T_SECONDPRIZE_AMOUNT = t_SECONDPRIZE_AMOUNT;
    }

    public float getT_THIRDPRIZE_AMOUNT() {
        return T_THIRDPRIZE_AMOUNT;
    }

    public void setT_THIRDPRIZE_AMOUNT(float t_THIRDPRIZE_AMOUNT) {
        T_THIRDPRIZE_AMOUNT = t_THIRDPRIZE_AMOUNT;
    }

    public float getT_NOPRIZE_AMOUNT() {
        return T_NOPRIZE_AMOUNT;
    }

    public void setT_NOPRIZE_AMOUNT(float t_NOPRIZE_AMOUNT) {
        T_NOPRIZE_AMOUNT = t_NOPRIZE_AMOUNT;
    }

    public String getBNO() {
        return BNO;
    }

    public void setBNO(String BNO) {
        this.BNO = BNO;
    }
}
