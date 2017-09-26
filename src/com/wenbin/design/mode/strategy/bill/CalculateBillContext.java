package com.wenbin.design.mode.strategy.bill;

import com.wenbin.design.mode.strategy.bill.calculate.IBillCalculateStrategy;
import com.wenbin.design.mode.strategy.bill.entry.Bill;
import com.wenbin.design.mode.strategy.bill.entry.Goods;

import java.util.List;

/**
 * Created by wenbin on 2017/9/26.
 */
public class CalculateBillContext {
    private IBillCalculateStrategy billCalculateInterface;
    private String sId;

    public CalculateBillContext(String sId) {
        this.sId = sId;
        billCalculateInterface = BillCalculateFactory.createInstance(sId);
    }

    public List<Bill> getResult(Goods goods) {
        return billCalculateInterface.calculate(goods);
    }

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
