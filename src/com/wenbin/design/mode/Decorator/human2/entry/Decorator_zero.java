package com.wenbin.design.mode.Decorator.human2.entry;

import com.wenbin.design.mode.Decorator.human2.IHuman;

/**
 * Created by wenbin on 2017/9/27.
 */
public class Decorator_zero implements IHuman {

    private IHuman human;

    public Decorator_zero(IHuman human) {
        this.human = human;
    }

    public void goHome() {
        System.out.print("回家!");
    }

    public void findMap() {
        System.out.print("找地图!");
    }

    @Override
    public void wearClothes() {
        human.wearClothes();
        goHome();
    }

    @Override
    public void walkToWhere() {
        human.walkToWhere();
        findMap();
    }
}
