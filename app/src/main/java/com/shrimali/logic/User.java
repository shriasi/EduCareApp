package com.shrimali.logic;

public class User {


    String UserSchool;
    String UserGrade;
    String UserPhone;
    String UserAddress;
    String UserSubjects;

    public User(String userSchool, String userGrade, String userPhone, String userAddress, String userSubjects) {
    }

    public String getUserSchool() {
        return UserSchool;
    }

    public void setUserSchool(String userSchool) {
        UserSchool = userSchool;
    }

    public String getUserGrade() {
        return UserGrade;
    }

    public void setUserGrade(String userGrade) {
        UserGrade = userGrade;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    public String getUserSubjects() {
        return UserSubjects;
    }

    public void setUserSubjects(String userSubjects) {
        UserSubjects = userSubjects;
    }
}