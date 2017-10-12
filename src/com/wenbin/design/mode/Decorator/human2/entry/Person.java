package com.wenbin.design.mode.Decorator.human2.entry;

import com.wenbin.design.mode.Decorator.human2.IHuman;

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

    public static void main(String[] args) {
        IHuman person = new Person();
        IHuman decorator = new Decorator_first(
                new Decorator_zero(person));
        decorator.wearClothes();
        decorator.walkToWhere();
    }
}