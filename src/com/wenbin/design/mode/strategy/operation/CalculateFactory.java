package com.wenbin.design.mode.strategy.operation;

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
