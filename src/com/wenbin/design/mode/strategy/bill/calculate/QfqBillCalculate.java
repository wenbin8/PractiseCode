package com.wenbin.design.mode.strategy.bill.calculate;

import com.wenbin.design.mode.strategy.bill.entry.Bill;
import com.wenbin.design.mode.strategy.bill.entry.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wenbin on 2017/9/26.
 */
public class QfqBillCalculate implements IBillCalculateStrategy {
    @Override
    public List<Bill> calculate(Goods goods) {
        List<Bill> billList = new ArrayList<>();
        Random random = new Random(100);
        Bill bill = new Bill();
        bill.setName("QFQ");
        bill.setInterest(random.nextLong() * 1000);
        bill.setInvest(random.nextLong() * 1000);
        bill.setStatus(0);
        billList.add(bill);
        return billList;
    }
}
