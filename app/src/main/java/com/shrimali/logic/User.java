package com.shrimali.logic;

import android.content.Context;
import android.content.SharedPreferences;

public class User {

    String userName;
    String email;
    String  firstName;
    String  lastName;
    String [] subjects;
    String school;
    String mobileNumber;
    String address;

    public User(){
        userName = "";
        email = "";
        firstName = "";
        lastName = "";
        subjects = null;
        school = "";
        mobileNumber = "";
        address = "";
    }

    public boolean save(){

        if(){
            SharedPreferences preferences = getSharedPreferences("USER" , Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
//            Gson gson = new Gson();
//            String s = gson.toJson(userList);
//            editor.putString("USER_DATA", s);
            editor.apply();
            return true;
        }else{
            return false;
        }
    }

    private SharedPreferences getSharedPreferences(String user, int modePrivate) {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        school = school;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
