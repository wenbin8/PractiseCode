package com.wenbin.base.containers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: wenbin
 * @Date: 2019/4/4 10:20
 * @Description:
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        Map<String, String> mapA = new HashMap<>();
        mapA.put("11111", "11111");

        Map<String, String> mapB = new ConcurrentHashMap<>(13);
        mapB.put("333333", "333333");
    }
}
