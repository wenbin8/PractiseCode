package com.wenbin.design.mode.proxy;

import com.wenbin.design.mode.proxy.entry.People;

/**
 * Created by wenbin on 2017/10/12.
 */
public class ProxyMain {
    public static void main(String[] args) {

        People people_1 =new People();
        people_1.setCash(60000);
        people_1.setUserName("jeck");


        People people_2 =new People();
        people_2.setCash(40000);
        people_2.setUserName("rose");

        People people_3 =new People();

        people_3.setCash(0);
        people_3.setUserName("tom");
        people_3.setVip("vip");

        BuyCarProxy proxy_buy = new BuyCarProxy();
        proxy_buy.setPeople(people_1);
        proxy_buy.buyMyCar();

        proxy_buy.setPeople(people_2);
        proxy_buy.buyMyCar();

        proxy_buy.setPeople(people_3);
        proxy_buy.buyMyCar();

    }
}
