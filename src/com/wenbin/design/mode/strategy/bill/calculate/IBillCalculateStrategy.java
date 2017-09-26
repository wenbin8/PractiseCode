package com.wenbin.design.mode.strategy.bill.calculate;

import com.wenbin.design.mode.strategy.bill.entry.Bill;
import com.wenbin.design.mode.strategy.bill.entry.Goods;

import java.util.List;

/**
 * Created by wenbin on 2017/9/26.
 */
public interface IBillCalculateStrategy {
    List<Bill> calculate(Goods goods);
}
