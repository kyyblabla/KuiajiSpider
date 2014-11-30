/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.spider.impl;

import com.fml.spider.kuaiji.CityStatu;
import com.fml.spider.kuaiji.model.City;
import com.fml.spider.kuaiji.spider.Spider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ky
 */
public class KuaijiSpider implements Spider {

    static final String header = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36";

    public KuaijiSpider() {

    }

    @Override
    public CityStatu tryConnect(String cityCode) throws Exception {

        String link_page = "http://www.hncz.gov.cn:8001/he-eams/NetService/ExternService/Apply/CompExam/Apply_CompExamSign_selectExam.jsp?isNewSign=true";

        String link_two = "http://www.hncz.gov.cn:8001/he-eams/Actions/Net/External/NetService/WebPersonalCompExamManageAction.do?method=enterCompExamNoticeTwo";

        String argee_link = "http://www.hncz.gov.cn:8001/he-eams/Actions/Net/External/NetService/WebPersonalCompExamManageAction.do?method=enterCompExamFourth";

        System.out.println("进入报名页");
        Connection connect = Jsoup.connect(link_page);
        connect.header("User-Agent", header);
        connect.timeout(5000);
        connect.execute();

        Response execute = connect.execute();

        Map<String, String> cookies = execute.cookies();
        Document parse = Jsoup.parse(execute.body());

        String currentPage = parse.select("input[name=currentPage]").attr("value");
        String examTypeId = parse.select("input[name=examSignManageVO.examTypeId]").attr("value");
        String pageToKen = parse.select("input[name=pageToKen]").attr("value");
        String pkRadios = cityCode;

        //PAGE_NET_COMP_EXAM_SELECT_EXAM
        //PAGE_NET_COMP_EXAM_SELECT_EXAM
//        System.out.println("currentPage::" + currentPage);
//        System.out.println("examTypeId::" + examTypeId);
//        System.out.println("pageToKen::" + pageToKen);
//        System.out.println("pkRadios::" + pkRadios);
//        System.out.println("111=================");
        Map<String, String> datas = new HashMap<>();

        datas.put("currentPage", currentPage);
        datas.put("examSignManageVO.examTypeId:CompExam", examTypeId);
        datas.put("pageToKen", pageToKen);
        datas.put("pkRadios", pkRadios);

        System.out.println("尝试获取数据：");

        connect = Jsoup.connect(link_two);
        connect.header("User-Agent", header);
        connect.method(Connection.Method.POST);
        connect.cookies(cookies);
        connect.data(datas);
        execute = connect.execute();

        parse = Jsoup.parse(execute.body());

        currentPage = parse.select("input[name=currentPage]").attr("value");
        pageToKen = parse.select("input[name=pageToKen]").attr("value");

        String text = parse.select("font[color=red]").text();

        if (text.contains("没有开放考试报名")) {
            return new CityStatu(1, text);
        } else if (text.contains("本次考试已报满")) {
            return new CityStatu(2, text); //考区座位已满
        } //考区座位已满，但有部分考生未交费，请继续关注！
        else if (text.contains("考区座位已满")) {
            return new CityStatu(3, text); //考区座位已满
        } else {

//            cookies.put("clientlanguage", "zh_CN");
//            
//            connect = Jsoup.connect(argee_link);
//            connect.header("User-Agent", header);
//            connect.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//            connect.header("Referer", "http://www.hncz.gov.cn:8001/he-eams/Actions/Net/External/NetService/WebPersonalCompExamManageAction.do?method=enterCompExamNoticeTwo");
//            connect.header("Connection", "keep-alive");
//            connect.header("Content-Type", "application/x-www-form-urlencoded");
//            connect.header("Cookie", cookies.toString().replaceAll("\\{|\\}", ""));
//            connect.header("Host", "www.hncz.gov.cn:8001");
//            connect.header("Accept-Encoding", "gzip,deflate");
//            connect.header("Accept-Language", "zh-CN,zh;q=0.8");
//            connect.header("Cache-Control", "wmax-age=0");
//
//            connect.method(Method.POST);
//            
//            connect.cookies(cookies);
//            System.out.println(cookies.toString().replaceAll("\\{|\\}", ""));
//            Map<String, String> aggdatas = new HashMap<>();
//
//            aggdatas.put("pageToKen", pageToKen);
//            aggdatas.put("currentPage", currentPage);
//            aggdatas.put("notice", "");
//
//            System.out.println(aggdatas);
//            connect.data(aggdatas);
//
//            execute = connect.execute();
//
//            System.out.println("同意报名");
//            System.out.println("====================");
//
//            parse = Jsoup.parse(execute.body());
//
//            System.out.println(parse.text());
            System.out.println("=======" + text);
            return new CityStatu(0, "也许可以报名!");
        }

    }

    @Override
    public List<City> getEnableCity() throws Exception {

        List<City> citys = new ArrayList<>();

        String link_page = "http://www.hncz.gov.cn:8001/he-eams/NetService/ExternService/Apply/CompExam/Apply_CompExamSign_selectExam.jsp?isNewSign=true";

        String header = "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko";
        System.out.println("进入报名页");
        Connection connect = Jsoup.connect(link_page);
        connect.timeout(5000);
        connect.header("User-Agent", header);
        connect.execute();
        Connection.Response execute = connect.execute();

        Document parse = Jsoup.parse(execute.body());

        Elements selects = parse.select("#displayTableId tbody tr");

        for (Element select : selects) {

            String pkRadios = select.select("input[name=pkRadios]").attr("value");
            String info = select.select("td").text();

            City c = new City();
            c.cityCode = pkRadios;
            c.cityName = info;
            citys.add(c);
        }

        return citys;
    }

    public static void tets() throws IOException {

        String link_page = "http://www.hncz.gov.cn:8001/he-eams/NetService/ExternService/Apply/CompExam/Apply_CompExamSign_selectExam.jsp?isNewSign=true";

        String link_two = "http://www.hncz.gov.cn:8001/he-eams/Actions/Net/External/NetService/WebPersonalCompExamManageAction.do?method=enterCompExamNoticeTwo";

        String header = "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko";

        System.out.println("进入报名页");
        Connection connect = Jsoup.connect(link_page);
        connect.header("User-Agent", header);
        connect.execute();
        Connection.Response execute = connect.execute();

        Map<String, String> cookies = execute.cookies();
        Document parse = Jsoup.parse(execute.body());

        String currentPage = parse.select("input[name=currentPage]").attr("value");
        String examTypeId = parse.select("input[name=examSignManageVO.examTypeId]").attr("value");
        String pageToKen = parse.select("input[name=pageToKen]").attr("value");
        String pkRadios = "5D52794C-C455-FBA2-B4F5-36CA1512A875";

        //PAGE_NET_COMP_EXAM_SELECT_EXAM
        //PAGE_NET_COMP_EXAM_SELECT_EXAM
        System.out.println("currentPage::" + currentPage);
        System.out.println("examTypeId::" + examTypeId);
        System.out.println("pageToKen::" + pageToKen);
        System.out.println("pkRadios::" + pkRadios);
        System.out.println("111=================");

        Map<String, String> datas = new HashMap<>();

//currentPage:PAGE_NET_COMP_EXAM_SELECT_EXAM
//examSignManageVO.examTypeId:CompExam
//pageToKen:24701
//pkRadios:5D52794C-C455-FBA2-B4F5-36CA1512A875
        datas.put("currentPage", currentPage);
        datas.put("examSignManageVO.examTypeId:CompExam", examTypeId);
        datas.put("pageToKen", pageToKen);
        datas.put("pkRadios", pkRadios);

        System.out.println("尝试获取数据：");

        connect = Jsoup.connect(link_two);
        connect.header("User-Agent", header);
        connect.method(Connection.Method.POST);
        connect.cookies(cookies);
        connect.data(datas);
        execute = connect.execute();
        parse = Jsoup.parse(execute.body());
        String text = parse.select("font[color=red]").text();

        System.out.println(text);

    }

    public void baoMing() throws IOException {

//        String url = "http://www.hncz.gov.cn:8001/he-eams/Actions/Net/External/NetService/WebPersonalCompExamManageAction.do?method=enterCompExamFourth";
//
//        Connection connect = Jsoup.connect(url);
//        connect.header("User-Agent", header);
//        connect.method(Connection.Method.POST);
//        connect.cookies(cookies);
//
//        Map<String, String> datas = new HashMap<>();
//
//        datas.put("currentPage", currentPage);
//        datas.put("examSignManageVO.examTypeId:CompExam", examTypeId);
//        datas.put("pageToKen", pageToKen);
//        datas.put("pkRadios", pkRadios);
//
//        connect.data(datas);
//
//        Connection.Response execute = connect.execute();
    }

    public static void main(String[] args) throws Exception {

        CityStatu tryConnect = new KuaijiSpider().tryConnect("5D52794C-C455-FBA2-B4F5-36CA1512A875");

        System.out.println(tryConnect);

    }

}
