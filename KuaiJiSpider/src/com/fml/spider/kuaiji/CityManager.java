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
import java.io.FileNotFoundException;
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
    private Spider spider;

    public CityManager(Spider spider) {

        this.spider = spider;

    }

    public City getACity(int i) {

        City c = null;

        if (i >= 0 || i < cityList.size()) {
            c = cityList.get(i);
        }

        return c;

    }

    public boolean initList() {

        if (initType == 1) {
            InputStream fr = null;
            try {
                fr = new FileInputStream(new File("config.xml"));
                Document parse = Jsoup.parse(fr, "utf-8", "http://www.baicu.com");
                System.out.println(parse.body());
                Elements selects = parse.select("option");
                for (Element select : selects) {
                    City c = new City();
                    c.cityCode = select.attr("value");
                    c.cityName = select.text();
                    cityList.add(c);
                }

                return cityList.size() > 0;

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
                cityList = spider.getEnableCity();
                return true;
            } catch (Exception ex) {
                Logger.getLogger(CityManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    public City getCity() {

        City c = null;

        synchronized (cityIndex) {

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

    public void updateCity(City newCity) {

        synchronized (cityList) {

            int i = 0;
            for (City city : cityList) {

                if (city.cityCode.equals(newCity.cityCode)) {

                    cityStatusUpdate(i);

                    break;
                }
                i++;
            }
        }

    }

    public abstract void cityStatusUpdate(int index);
}
