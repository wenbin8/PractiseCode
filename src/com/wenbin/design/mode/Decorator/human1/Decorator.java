package com.wenbin.design.mode.Decorator.human1;

/**
 * Created by wenbin on 2017/9/27.
 */
public abstract class Decorator implements IHuman {
    private IHuman human;

    public Decorator(IHuman human) {
        this.human = human;
    }

    public void wearClothes() {
        human.wearClothes();
    }

    public void walkToWhere() {
        human.walkToWhere();
    }
}
