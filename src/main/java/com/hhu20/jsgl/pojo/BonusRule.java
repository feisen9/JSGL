package com.hhu20.jsgl.pojo;

public class BonusRule {
    private float stu_1;    //学生获得一等奖的奖金
    private float stu_2;    //学生获得二等奖的奖金
    private float stu_3;    //学生获得三等奖奖金
    private float stu_no;    //学生不获奖奖金
    private float stu_t;    //学生获得特等奖的奖金
    private float tea_1;    //老师获得一等奖的奖金
    private float tea_2;    //老师获得二等奖的奖金
    private float tea_3;    //老师获得三等奖奖金
    private float tea_no;    //老师不获奖奖金
    private float tea_t;    //老师获得特等奖的奖金
    private float team_1;    //团队获得一等奖的奖金
    private float team_2;    //团队获得二等奖的奖金
    private float team_3;    //团队获得三等奖奖金
    private float team_no;    //团队不获奖奖金
    private float team_t;    //团队获得特等奖的奖金
    private String clevel;     //奖金规则编号


    @Override
    public String toString() {
        return "BonusRule{" +
                "stu_1=" + stu_1 +
                ", stu_2=" + stu_2 +
                ", stu_3=" + stu_3 +
                ", stu_no=" + stu_no +
                ", stu_t=" + stu_t +
                ", tea_1=" + tea_1 +
                ", tea_2=" + tea_2 +
                ", tea_3=" + tea_3 +
                ", tea_no=" + tea_no +
                ", tea_t=" + tea_t +
                ", team_1=" + team_1 +
                ", team_2=" + team_2 +
                ", team_3=" + team_3 +
                ", team_no=" + team_no +
                ", team_t=" + team_t +
                ", CLEVEL='" + clevel + '\'' +
                '}';
    }

    public float getStu_1() {
        return stu_1;
    }

    public void setStu_1(float stu_1) {
        this.stu_1 = stu_1;
    }

    public float getStu_2() {
        return stu_2;
    }

    public void setStu_2(float stu_2) {
        this.stu_2 = stu_2;
    }

    public float getStu_3() {
        return stu_3;
    }

    public void setStu_3(float stu_3) {
        this.stu_3 = stu_3;
    }

    public float getStu_no() {
        return stu_no;
    }

    public void setStu_no(float stu_no) {
        this.stu_no = stu_no;
    }

    public float getStu_t() {
        return stu_t;
    }

    public void setStu_t(float stu_t) {
        this.stu_t = stu_t;
    }

    public float getTea_1() {
        return tea_1;
    }

    public void setTea_1(float tea_1) {
        this.tea_1 = tea_1;
    }

    public float getTea_2() {
        return tea_2;
    }

    public void setTea_2(float tea_2) {
        this.tea_2 = tea_2;
    }

    public float getTea_3() {
        return tea_3;
    }

    public void setTea_3(float tea_3) {
        this.tea_3 = tea_3;
    }

    public float getTea_no() {
        return tea_no;
    }

    public void setTea_no(float tea_no) {
        this.tea_no = tea_no;
    }

    public float getTea_t() {
        return tea_t;
    }

    public void setTea_t(float tea_t) {
        this.tea_t = tea_t;
    }

    public float getTeam_1() {
        return team_1;
    }

    public void setTeam_1(float team_1) {
        this.team_1 = team_1;
    }

    public float getTeam_2() {
        return team_2;
    }

    public void setTeam_2(float team_2) {
        this.team_2 = team_2;
    }

    public float getTeam_3() {
        return team_3;
    }

    public void setTeam_3(float team_3) {
        this.team_3 = team_3;
    }

    public float getTeam_no() {
        return team_no;
    }

    public void setTeam_no(float team_no) {
        this.team_no = team_no;
    }

    public float getTeam_t() {
        return team_t;
    }

    public void setTeam_t(float team_t) {
        this.team_t = team_t;
    }

    public String getClevel() {
        return clevel;
    }

    public void setClevel(String clevel) {
        this.clevel = clevel;
    }

}
