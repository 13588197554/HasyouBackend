package com.fly.spider;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

/**
 * @author david
 * @date 05/08/18 19:46
 */
public class BaseSpider {

    protected Document getQuickConn(String url) throws IOException {
            Connection connect = Jsoup.connect(url);
            connect.userAgent("CatchBot/1.0;  http://www.catchbot.com");
            connect = Jsoup.connect(url).timeout(5000);
            connect.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            connect.header("Accept-Encoding", "gzip, deflate, sdch");
            connect.header("Accept-Language", "zh-CN,zh;q=0.8");
            return connect.get();
    }

    protected Document getConn(String url, Map<String, String> map) throws IOException {
        Connection connect = Jsoup.connect(url);
        connect.userAgent("CatchBot/1.0;  http://www.catchbot.com");
        connect = Jsoup.connect(url).timeout(5000);
        connect.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        connect.header("Accept-Encoding", "gzip, deflate, sdch");
        connect.header("Accept-Language", "zh-CN,zh;q=0.8");
        return connect.get();
    }

}
