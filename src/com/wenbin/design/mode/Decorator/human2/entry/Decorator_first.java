package com.wenbin.design.mode.Decorator.human2.entry;

import com.wenbin.design.mode.Decorator.human2.IHuman;

/**
 * Created by wenbin on 2017/9/27.
 */
public class Decorator_first implements IHuman {

    private IHuman human;

    public Decorator_first(IHuman human) {
        this.human = human;
    }

    public void wearClothes() {
        human.wearClothes();
        goClothespress();
    }

    public void walkToWhere() {
        human.walkToWhere();
        findPlaceOnMap();
    }

    public void goClothespress() {
        System.out.println("去衣柜找找看。。");
    }

    public void findPlaceOnMap() {
        System.out.println("在Map上找找。。");
    }
}
