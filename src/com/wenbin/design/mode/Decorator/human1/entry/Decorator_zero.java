package com.wenbin.design.mode.Decorator.human1.entry;

import com.wenbin.design.mode.Decorator.human1.Decorator;
import com.wenbin.design.mode.Decorator.human1.IHuman;

/**
 * Created by wenbin on 2017/9/27.
 */
public class Decorator_zero extends Decorator {

    public Decorator_zero(IHuman human) {
        super(human);
    }

    public void goHome() {
        System.out.print("回家!");
    }

    public void findMap() {
        System.out.print("找地图!");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goHome();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findMap();
    }
}
