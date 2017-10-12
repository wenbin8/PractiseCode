package com.wenbin.design.mode.proxy;

import com.wenbin.design.mode.proxy.entry.People;

/**
 * Created by wenbin on 2017/10/12.
 */
public class BuyCarProxy implements IBuyCar {
    private People people;

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public void buyMyCar() {
        if (people.getVip() == "vip"){
            people.buyMyCar();
            return ;
        }
        if(people.getCash()>=50000){
            System.out.println(people.getUserName()+"买了新车，交易结束！");
        }
        else
        {
            System.out.println(people.getUserName()+"钱不够，不能买车，继续比赛！");
        }
    }
}
