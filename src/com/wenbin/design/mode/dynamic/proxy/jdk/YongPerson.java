package com.wenbin.design.mode.dynamic.proxy.jdk;

/**
 * Created by wenbin on 2018/1/21.
 */
public class YongPerson implements IPerson {
    @Override
    public String readBook(String bookName) {
        System.out.println("年轻人读书.," + bookName);

        return "多读书,长脑子.";
    }

    @Override
    public void findLove(String name) {
        System.out.println(name);
    }

}
