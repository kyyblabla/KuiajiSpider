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
public class City {

    public String cityName;
    public String cityCode;
    public boolean enableReq = false;
    public String reqStatus = "";
    public boolean needTest = true;
    public String netInfo="";

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
