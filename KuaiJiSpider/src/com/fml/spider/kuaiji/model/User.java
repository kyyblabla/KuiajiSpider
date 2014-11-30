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
    boolean success = false;
   
    
    public User(String userName, String passWord, String cityCode) {
        this.userName = userName;
        this.passWord = passWord;
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", passWord=" + passWord + ", cityCode=" + cityCode + '}';
    }

}
