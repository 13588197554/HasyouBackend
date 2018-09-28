package com.fly.util;

public class ProvinceUtil {

    public static String getNameByPinyin(String pinyin) {
        switch (pinyin) {
            case "china":
                return "中国";
            case "anhui":
                return "安徽";
            case "fujian":
                return "福建";
            case "gansu":
                return "甘肃";
            case "guangdong":
                return "广东";
            case "guangxi":
                return "广西";
            case "hainan":
                return "海南";
            case "hebei":
                return "河北";
            case "heilongjiang":
                return "黑龙江";
            case "henan":
                return "河南";
            case "jilin":
                return "吉林";
            case "liaoning":
                return "辽宁";
            case "hunan":
                return "湖南";
            case "hubei":
                return "湖北";
            case "yunnan":
                return "云南";
            case "shandong":
                return "山东";
            case "jiangsu":
                return "江苏";
            case "jiangxi":
                return "江西";
            case "zhejiang":
                return "浙江";
            case "xizang":
                return "西藏";
            case "xinjiang":
                return "新疆";
            case "sichuan":
                return "四川";
            case "shaanxi":
                return "陕西";
            case "shanxi":
                return "山西";
            case "ningxia":
                return "宁夏";
            case "taiwan":
                return "台湾";
            case "neimenggu":
                return "内蒙古";
            case "guizhou":
                return "贵州";
            case "qinghai":
                return "青海";
            default:
                return  null;
        }
    }

}
