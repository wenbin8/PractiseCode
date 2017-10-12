package com.wenbin.design.mode.Decorator.human1.entry;

import com.wenbin.design.mode.Decorator.human1.Decorator;
import com.wenbin.design.mode.Decorator.human1.IHuman;

/**
 * Created by wenbin on 2017/9/27.
 */
public class Person implements IHuman {

    @Override
    public void wearClothes() {
        System.out.println("穿什么呢。。");
    }

    @Override
    public void walkToWhere() {
        System.out.println("去哪里呢。。");
    }


}