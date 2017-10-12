package com.wenbin.base.value;

/**
 * String类型之间的比较
 * Created by wenbin on 2017/10/12.
 */
public class StringCompare {

    public static void main(String[] args) {
        /**
         * java的内存中会维护一个字符串常量池，String对象只能被创建，不能被修改
         */
        System.out.println("abc" == "abc");

        String a = "abc";
        String b = "abc";
        System.out.println(a == b);

        String a1 = new String("abc");
        String a2 = new String("abc");
        System.out.println(a1 == a2);
    }
}
