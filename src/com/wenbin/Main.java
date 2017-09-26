package com.wenbin;

import com.wenbin.design.mode.strategy.bill.CalculateBillContext;
import com.wenbin.design.mode.strategy.bill.entry.Bill;
import com.wenbin.design.mode.strategy.bill.entry.Goods;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Goods goods = new Goods();
        CalculateBillContext qfqBillContext = new CalculateBillContext("1");
        List<Bill> qfqBillList = qfqBillContext.getResult(goods);

        System.out.println(qfqBillList);

        CalculateBillContext dsBillContext = new CalculateBillContext("2");
        List<Bill> dsBillList = dsBillContext.getResult(goods);

        System.out.println(dsBillList);

    }
}
