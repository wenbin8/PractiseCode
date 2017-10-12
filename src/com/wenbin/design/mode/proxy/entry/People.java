package com.wenbin.design.mode.proxy.entry;

import com.wenbin.design.mode.proxy.IBuyCar;

/**
 * 人
 * Created by wenbin on 2017/10/12.
 */
public class People implements IBuyCar{
    private int cash;
    private String vip;
    private String userName;


    @Override
    public void buyMyCar() {
        System.out.print(userName+"是vip 客户，可以直接购买新车！");
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
