/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.model;

/**
 *
 * @author ky
 */
public class User {

    String userName;
    String passWord;
    String cityCode;
    boolean success;

    public User(String userName, String passWord, String cityCode) {
        this.userName = userName;
        this.passWord = passWord;
        this.cityCode = cityCode;
    }

    public User(String userName, String passWord, String cityCode, boolean success) {
        this.userName = userName;
        this.passWord = passWord;
        this.cityCode = cityCode;
        this.success = success;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", passWord=" + passWord + ", cityCode=" + cityCode + '}';
    }

}
