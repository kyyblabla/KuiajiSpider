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
    String cardCode;
    boolean success = false;
    boolean vaild = true;

    public User(String user) {

        try {
            String[] split = user.split("#");
            this.userName = split[0];
            this.passWord = split[1];
            this.cityCode = split[2];
            this.cardCode = split[3];
            this.success = split[4].equals("true");

        } catch (Exception e) {
            this.vaild = true;
        }

    }

    public User(String userName, String passWord, String cityCode, String cardCode, boolean success) {
        this.userName = userName;
        this.passWord = passWord;
        this.cityCode = cityCode;
        this.cardCode = cardCode;
        this.success = success;
    }

    public User(String userName, String passWord, String cityCode, String cardCode) {
        this.userName = userName;
        this.passWord = passWord;
        this.cityCode = cityCode;
        this.cardCode = cardCode;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public boolean isVaild() {
        return vaild;
    }

    public void setVaild(boolean vaild) {
        this.vaild = vaild;
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
        return userName + "#" + passWord + "#" + cityCode + "#" + cardCode + "#" + success;
    }

}
