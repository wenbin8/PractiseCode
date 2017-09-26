package com.wenbin.design.mode.strategy.bill.entry;

/**
 * Created by wenbin on 2017/9/26.
 */
public class Bill {
    private String name;
    private long invest;
    private long interest;
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getInterest() {
        return interest;
    }

    public void setInterest(long interest) {
        this.interest = interest;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getInvest() {

        return invest;
    }

    public void setInvest(long invest) {
        this.invest = invest;
    }

    @Override
    public String toString() {
        return "账单名:" + this.name + "本金:" + this.invest + "利息:" + this.interest;
    }
}
