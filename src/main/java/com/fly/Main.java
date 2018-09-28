package com.fly;

import com.fly.util.Util;

/**
 * @author david
 * @date 23/08/18 17:12
 */
public class Main {

    public static void main(String[] args) {
        String time = Util.getCurrentFormatTime();
        Long aLong = Util.getTimestamp(time);
        System.out.println(aLong);
    }

}
