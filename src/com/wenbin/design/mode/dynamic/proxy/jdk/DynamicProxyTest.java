package com.wenbin.design.mode.dynamic.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by wenbin on 2018/1/21.
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        YongPerson yongPerson = new YongPerson();

        ClassLoader classLoader = yongPerson.getClass().getClassLoader();
        Class<?>[] interfaces = YongPerson.class.getInterfaces();

        IPerson iPerson = (IPerson) Proxy.newProxyInstance(classLoader, interfaces, new YongHandelProxy(yongPerson));

        String bookName = "分布式存储";

//        String s = iPerson.readBook(bookName);
//
//        System.out.printf(s);

        iPerson.findLove("撒的发是的");
    }
}
