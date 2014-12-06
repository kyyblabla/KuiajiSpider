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
<<<<<<< HEAD
        return "City{" + "cityName=" + cityName + ", cityCode=" + cityCode + ", enableReq=" + enableReq + ", reqStatus=" + reqStatus + ", needTest=" + needTest + ", netInfo=" + netInfo + '}';
    }

    

=======
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
}
