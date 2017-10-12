package com.wenbin.base.value;

import com.wenbin.base.value.entry.Cust;

/**
 * 对象值传递
 * Created by wenbin on 2017/10/12.
 */
public class ObjectValueTransmitTest {
    public static void main(String[] args) {
        Cust cust = new Cust();
        cust.name = "123";

        /**
         * 对象cust的引用值被封装在setName方法的栈帧中,在方法内吧属性name值修改为null,就是把引用值指向堆内从中的name值为null,
         * 而main方法栈帧中存放的cust引用值和setName方法存放的引用之同时指向的对内存中的同一快地址.所以在main方法中cust.name
         * 也为null.
         */
        cust.setName(cust);

        System.out.println(cust.name);

        cust.name = "123";

        /**
         * 对象cust在setName方法的栈帧中引用值并赋值未null而main方法的栈帧中依然存放着cust对象的引用值
         */
        cust.setCust(cust);
        System.out.println(cust.name);

        setCust(cust);
        System.out.println(cust.name);

        cust.setName456(cust);

        System.out.println(cust.name);


    }

    public static void setCust(Cust cust) {
        cust = null;
    }
}
