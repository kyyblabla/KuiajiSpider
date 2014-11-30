/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji;

/**
 *
 * @author ky
 */
public class CityStatu {

    public CityStatu(int code, String info) {

        this.code = code;
        this.info = info;
    }
    int code = 0;
    String info = "";

    @Override
    public String toString() {
        return "CityStatu{" + "code=" + code + ", info=" + info + '}';
    }

}
