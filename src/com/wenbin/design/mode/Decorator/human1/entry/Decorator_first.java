package com.wenbin.design.mode.Decorator.human1.entry;

import com.wenbin.design.mode.Decorator.human1.Decorator;
import com.wenbin.design.mode.Decorator.human1.IHuman;

/**
 * Created by wenbin on 2017/9/27.
 */
public class Decorator_first extends Decorator {

    public Decorator_first(IHuman human) {
        super(human);
    }

    public void wearClothes() {
        super.wearClothes();
        goClothespress();
    }

    public void walkToWhere() {
        super.walkToWhere();
        findPlaceOnMap();
    }

    public void goClothespress() {
        System.out.println("去衣柜找找看。。");
    }

    public void findPlaceOnMap() {
        System.out.println("在Map上找找。。");
    }
}
