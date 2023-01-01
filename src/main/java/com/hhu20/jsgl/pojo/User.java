package com.hhu20.jsgl.pojo;

public class User {
    String userId;
    String password;
    String userType;
    String userName;

    public User() {
    }

    public User(String userId, String password, String userType, String userName) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
        this.userName = userName;
    }

    public User(String userId, String password, String userType) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
