package com.wenbin.design.mode.strategy.operation;

import com.wenbin.design.mode.strategy.operation.entry.AddCalculate;
import com.wenbin.design.mode.strategy.operation.entry.ICalculateStrategy;
import com.wenbin.design.mode.strategy.operation.entry.SubtractCalculate;

/**
 * Created by wenbin on 2017/9/26.
 */
public class CalculateFactory {
    public static ICalculateStrategy createInstance(char flag) {

        if (flag == '+') {
            return new AddCalculate();
        } else if (flag == '-') {
            return new SubtractCalculate();
        }
        return null;
    }
}
