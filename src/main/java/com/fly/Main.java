package com.fly;

import net.bytebuddy.asm.Advice;

import java.util.*;

/**
 * @author david
 * @date 23/08/18 17:12
 */
public class Main {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("21");
        set.add("13");
        set.add("41");
        set.add("10");
        set.add("1");

        System.out.println(set);

        Set<Integer> s = new HashSet<>();
        s.add(21);
        s.add(13);
        s.add(41);
        s.add(10);
        s.add(1);

        System.out.println(s);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("21");
        ts.add("13");
        ts.add("41");
        ts.add("10");
        ts.add("1");
        System.out.println(ts);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Map<Integer, Integer> map2 = new HashMap<>();
        Integer[] o = new Integer[1];
        map.forEach((k, v) -> {
            map2.put(k, v);
            o[0] = k;
            System.out.println(k + " --- " + v);
        });

        boolean b = Objects.deepEquals(map, map2);
        System.out.println(b);

        new HashMap<String, String>() {
        };
    }

}
