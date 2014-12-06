/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji;

import com.fml.spider.kuaiji.model.City;
import com.fml.spider.kuaiji.spider.Spider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ky
 */
public abstract class CityManager {

    public static int initType = 2;
    public static List<City> cityList = new ArrayList<>();
    public static Integer cityIndex = 0;
    private final Spider spider;

    public CityManager(Spider spider) {

        this.spider = spider;

    }

    public void work() {

        Thread t;
        t = new Thread() {

            @Override
            public void run() {

                while (true) {
                    updateCityList();

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CityManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };

        t.start();

    }

    public City getACity(int i) {

        City c = null;

        if (i >= 0 || i < cityList.size()) {
            c = cityList.get(i);
        }

        return c;

    }

<<<<<<< HEAD
    public City getACity(String code) {

        for (City c : cityList) {
            if (c.cityCode.equals(code)) {
                return c;
            }
        }
        return null;

    }

=======
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
    public boolean isInCityList(City city) {

        for (City c : cityList) {
            if (city.cityCode.equals(c.cityCode)) {
                return true;
            }
        }

        return false;

    }

    public void updateCityList() {

        synchronized (this) {

            if (initType == 1) {
                InputStream fr = null;
                try {
                    fr = new FileInputStream(new File("config.xml"));
                    Document parse = Jsoup.parse(fr, "utf-8", "http://www.baicu.com");
                    System.out.println(parse.body());
                    Elements selects = parse.select("option");
                    for (Element select : selects) {
                        City ec = new City();
                        ec.cityCode = select.attr("value");
                        ec.cityName = select.text();
                        boolean inCityList = isInCityList(ec);
                        if (inCityList != true) {
                            cityList.add(ec);
<<<<<<< HEAD
                            onAddNewCity(ec);
=======
                            addNewCity(ec);
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
                        }
                    }

                } catch (Exception ex) {

                } finally {

                    if (fr != null) {
                        try {
                            fr.close();
                        } catch (IOException ex) {
                            Logger.getLogger(CityManager.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }

            } else {
                try {

                    List<City> enableCity = spider.getEnableCity();

                    for (City ec : enableCity) {
                        boolean inCityList = isInCityList(ec);
                        if (inCityList != true) {
                            cityList.add(ec);
<<<<<<< HEAD
                            onAddNewCity(ec);
=======
                            addNewCity(ec);
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(CityManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public City getCity() {

        City c = null;

        synchronized (this) {

            if (cityIndex >= cityList.size()) {
                cityIndex = 0;
            }

            int count = 0;
            while (true) {

                if (count >= cityList.size()) {
                    break;
                }

                City get = cityList.get(cityIndex++);
                if (get.enableReq == true || get.needTest == false) {
                    ++count;
                } else {
                    c = get;
                    break;
                }
            }

        }
        return c;
    }

    public void updateCityInfo(City newCity) {

        synchronized (this) {

            int i = 0;
            for (City city : cityList) {

                if (city.cityCode.equals(newCity.cityCode)) {

<<<<<<< HEAD
                    onCityStatusUpdate(i);
=======
                    cityStatusUpdate(i);
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5

                    break;
                }
                i++;
            }
        }

    }

<<<<<<< HEAD
    public abstract void onCityStatusUpdate(int index);

    public abstract void onAddNewCity(City city);
=======
    public abstract void cityStatusUpdate(int index);

    public abstract void addNewCity(City city);
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5

}
