package com.fly.config;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Properties;

/**
 * @author david
 * @date 07/08/18 20:06
 */
public class SystemConfig {

    public static Properties global = new Properties();
    public static String configUrl = "http://118.24.129.227/system/";

    static {
        try {
            Document document = Jsoup.connect(configUrl).get();
            Elements spans = document.select("span");
            for (Element e : spans) {
                String key = e.attr("name");
                String value = e.text().trim();
                global.setProperty(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
