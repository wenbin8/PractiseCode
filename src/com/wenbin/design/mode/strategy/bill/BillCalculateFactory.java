package com.wenbin.design.mode.strategy.bill;

import com.wenbin.design.mode.strategy.bill.calculate.IBillCalculateStrategy;
import com.wenbin.design.mode.strategy.bill.calculate.DsBillCalculate;
import com.wenbin.design.mode.strategy.bill.calculate.QfqBillCalculate;

/**
 * Created by wenbin on 2017/9/26.
 */
public class BillCalculateFactory {

    public static IBillCalculateStrategy createInstance(String sId) {
        if (sId.equals("1")) {
            return new QfqBillCalculate();
        } else if (sId.equals("2")) {
            return new DsBillCalculate();
        }
        return null;
    }

}
