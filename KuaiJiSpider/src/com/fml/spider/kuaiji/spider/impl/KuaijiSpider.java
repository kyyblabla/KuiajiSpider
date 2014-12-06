/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.spider.impl;

<<<<<<< HEAD
import com.fml.spider.kuaiji.model.CityStatu;
=======
import com.fml.spider.kuaiji.CityStatu;
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
import com.fml.spider.kuaiji.model.City;
import com.fml.spider.kuaiji.spider.Spider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Connection;
<<<<<<< HEAD
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
=======
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ky
 */
public class KuaijiSpider implements Spider {

<<<<<<< HEAD
    static final String header = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36";

    public KuaijiSpider() {

    }

    @Override
    public CityStatu tryConnect(String cityCode) throws Exception {

=======
    @Override
    public CityStatu tryConnect(String cityCode) throws Exception {

//        String link_page = "http://www.hncz.gov.cn:8001/he-eams/NetService/ExternService/Apply/CompExam/Apply_CompExamSign_selectExam.jsp?isNewSign=true";
//        String link_one = "http://www.hncz.gov.cn:8001/he-eams/Actions/Net/External/NetService/WebPersonalCompExamManageAction.do?method=enterSelectCompExamOne";
//        String link_two = "http://www.hncz.gov.cn:8001/he-eams/Actions/Net/External/NetService/WebPersonalCompExamManageAction.do?method=enterCompExamNoticeTwo";
//        String header = "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko";
//        System.out.println("进入报名页");
//        Connection connect = Jsoup.connect(link_page);
//        connect.header("User-Agent", header);
//        connect.execute();
//        Connection.Response execute = connect.execute();
//        Map<String, String> cookies = execute.cookies();
//        Document parse = Jsoup.parse(execute.body());
//        String pageToKen = parse.select("input[name=pageToKen]").attr("value");
//        String quarerPid = parse.select("input[name=examSignManageVO.quarerPid]").attr("value");
//        String examMainPid = parse.select("input[name=examSignManageVO.examMainPid]").attr("value");
//        String currentPage = parse.select("input[name=currentPage]").attr("value");
//        //PAGE_NET_COMP_EXAM_SELECT_EXAM
//        //PAGE_NET_COMP_EXAM_SELECT_EXAM
//        System.out.println("pageToKen::" + pageToKen);
//        System.out.println("quarerPid::" + quarerPid);
//        System.out.println("mainId::" + examMainPid);
//        System.out.println("currentPage::" + currentPage);
//        System.out.println("111=================");
//        System.out.println("尝试获取数据：");
//        Map<String, String> datas = new HashMap<>();
//        datas.put("currentPage", currentPage);
//        datas.put("pageToKen", pageToKen);          //E1C303FA-B81E-6815-833B-D1DD2FDB6123
//        datas.put("examSignManageVO.testAreaPid", cityCode);
//        datas.put("examSignManageVO.quarerPid", quarerPid);
//        datas.put("examSignManageVO.examMainPid", examMainPid);
//        connect = Jsoup.connect(link_one);
//        connect.header("User-Agent", header);
//        connect.method(Connection.Method.POST);
//        connect.cookies(cookies);
//        connect.data(datas);
//        execute = connect.execute();
//        parse = Jsoup.parse(execute.body());
//        String text = parse.select("font[color=red]").text();
//        //当前考区没有开放考试报名,或者座位分配已满!
//        System.out.println(text);
//        if (text.contains("没有开放考试报名")) {
//            return new CityStatu(1, text);
//        }
//        pageToKen = parse.select("input[name=pageToKen]").attr("value");
//        quarerPid = parse.select("input[name=examSignManageVO.quarerPid]").attr("value");
//        examMainPid = parse.select("input[name=examSignManageVO.examMainPid]").attr("value");
//        currentPage = parse.select("input[name=currentPage]").attr("value");
//        System.out.println("pageToKen::" + pageToKen);
//        System.out.println("quarerPid::" + quarerPid);
//        System.out.println("mainId::" + examMainPid);
//        System.out.println("currentPage::" + currentPage);
//        System.out.println("22222=================");
//        datas.put("pageToKen", pageToKen);          //E1C303FA-B81E-6815-833B-D1DD2FDB6123 
//        datas.put("examSignManageVO.quarerPid", quarerPid);
//        datas.put("examSignManageVO.examMainPid", examMainPid);
//        datas.put("currentPage", currentPage);
//        /*
//         currentPage:PAGE_NET_COMP_EXAM_SELECT_EXAM
//         examSignManageVO.quarerPid:E1C303FA-B81E-6815-833B-D1DD2FDB6123
//         pageToKen:15473
//         examSignManageVO.examMainPid:CompExam2014
//         examSignManageVO.testAreaPid:E84E36EE-72C3-818F-AF07-01FFF500A587
//        
//         */
//        connect = Jsoup.connect(link_two);
//        connect.header("User-Agent", header);
//        connect.method(Connection.Method.POST);
//        connect.cookies(cookies);
//        connect.data(datas);
//        execute = connect.execute();
//        parse = Jsoup.parse(execute.body());
//        //System.out.println(parse.body());
//        //错误提示 本次考试已报满，请关注下一期考试
//        text = parse.select("font[color=red]").text();
//        if (text.contains("本次考试已报满")) {
//            return new CityStatu(2, text); //考区座位已满
//        } //考区座位已满，但有部分考生未交费，请继续关注！
//        else if (text.contains("考区座位已满")) {
//            return new CityStatu(3, text); //考区座位已满
//        }
//
//        return new CityStatu(0, "也许可以报名!");
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
        String link_page = "http://www.hncz.gov.cn:8001/he-eams/NetService/ExternService/Apply/CompExam/Apply_CompExamSign_selectExam.jsp?isNewSign=true";

        String link_two = "http://www.hncz.gov.cn:8001/he-eams/Actions/Net/External/NetService/WebPersonalCompExamManageAction.do?method=enterCompExamNoticeTwo";

<<<<<<< HEAD
        String argee_link = "http://www.hncz.gov.cn:8001/he-eams/Actions/Net/External/NetService/WebPersonalCompExamManageAction.do?method=enterCompExamFourth";
=======
        String header = "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko";
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5

        System.out.println("进入报名页");
        Connection connect = Jsoup.connect(link_page);
        connect.header("User-Agent", header);
<<<<<<< HEAD
        connect.timeout(5000);
        connect.execute();

        Response execute = connect.execute();
=======
        connect.execute();
        Connection.Response execute = connect.execute();
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5

        Map<String, String> cookies = execute.cookies();
        Document parse = Jsoup.parse(execute.body());

        String currentPage = parse.select("input[name=currentPage]").attr("value");
        String examTypeId = parse.select("input[name=examSignManageVO.examTypeId]").attr("value");
        String pageToKen = parse.select("input[name=pageToKen]").attr("value");
        String pkRadios = cityCode;

        //PAGE_NET_COMP_EXAM_SELECT_EXAM
        //PAGE_NET_COMP_EXAM_SELECT_EXAM
<<<<<<< HEAD
//        System.out.println("currentPage::" + currentPage);
//        System.out.println("examTypeId::" + examTypeId);
//        System.out.println("pageToKen::" + pageToKen);
//        System.out.println("pkRadios::" + pkRadios);
//        System.out.println("111=================");
        Map<String, String> datas = new HashMap<>();

=======
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
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
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
<<<<<<< HEAD

        parse = Jsoup.parse(execute.body());

        currentPage = parse.select("input[name=currentPage]").attr("value");
        pageToKen = parse.select("input[name=pageToKen]").attr("value");

        String text = parse.select("font[color=red]").text();

=======
        parse = Jsoup.parse(execute.body());
        String text = parse.select("font[color=red]").text();

        System.out.println(text);

>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
        if (text.contains("没有开放考试报名")) {
            return new CityStatu(1, text);
        } else if (text.contains("本次考试已报满")) {
            return new CityStatu(2, text); //考区座位已满
        } //考区座位已满，但有部分考生未交费，请继续关注！
        else if (text.contains("考区座位已满")) {
            return new CityStatu(3, text); //考区座位已满
        } else {
<<<<<<< HEAD

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
=======
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
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
<<<<<<< HEAD
        connect.timeout(5000);
=======
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5
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

<<<<<<< HEAD
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
=======
    public static void main(String[] args) throws Exception {

        new KuaijiSpider().tryConnect("xxx");
>>>>>>> 763ab1f6614cb9d2fff901e103919a239b182cc5

    }

}
