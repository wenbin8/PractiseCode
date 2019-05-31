package com.wenbin.base.arrays;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: wenbin
 * @Date: 2019/2/21 16:54
 * @Description:
 */
public class Test {

    private void t1(String str) {
        List<String> aList = Arrays.asList(str.split(""));
        Set<String> set = new HashSet<>();

        for (String s : aList) {
            set.add(s);
        }

        System.out.println(set.size() < aList.size());
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.t1("sfd");
    }
}
