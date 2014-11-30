/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji;

import com.fml.spider.kuaiji.model.City;
import com.fml.spider.kuaiji.spider.Spider;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ky
 */
public class WorkThread extends Thread {

    private Spider spider;
    private CityManager manager = null;
    private int sleepTime = 3;

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime < 1 ? 1 : sleepTime;
    }

    public WorkThread(CityManager manager, Spider spider) {

        this.manager = manager;
        this.spider = spider;
    }

    @Override
    public void run() {

        while (true) {

            City city = manager.getCity();

            if (city == null) {
                System.out.println(Thread.currentThread().getName() + "结束线程!");
                break;
            }

            System.out.println(Thread.currentThread().getName() + "测试:" + city.cityName);

            try {
                CityStatu cityStatus = spider.tryConnect(city.cityCode);
                city.netInfo = cityStatus.info;
                if (cityStatus.code == 1) {
                    city.reqStatus = "未开放报名";
                    city.enableReq = false;
                } else if (cityStatus.code == 2) {
                    city.reqStatus = "报名已满";
                    city.enableReq = false;
                } else if (cityStatus.code == 3) {
                    city.reqStatus = "已满，有未缴费";
                    city.enableReq = false;
                } else {
                    city.reqStatus = "可以报名";
                    city.enableReq = true;
                }

            } catch (Exception ex) {
                city.reqStatus = "可以报名";
                city.enableReq = false;
            }

            manager.updateCityInfo(city);

            try {
                System.out.println("sleep:" + this.sleepTime);
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WorkThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
