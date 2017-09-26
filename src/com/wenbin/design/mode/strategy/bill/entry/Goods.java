package com.wenbin.design.mode.strategy.bill.entry;

import java.util.Date;

/**
 * Created by wenbin on 2017/9/26.
 */
public class Goods {
    private Date beginDate;
    private Date loneDate;
    private Date endDate;
    private Date firstBackDate;
    private long money;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getLoneDate() {
        return loneDate;
    }

    public void setLoneDate(Date loneDate) {
        this.loneDate = loneDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getFirstBackDate() {
        return firstBackDate;
    }

    public void setFirstBackDate(Date firstBackDate) {
        this.firstBackDate = firstBackDate;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }
}
