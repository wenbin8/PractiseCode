package com.wenbin.design.mode.strategy.operation.entry;

/**
 * Created by wenbin on 2017/9/26.
 */
public class AddCalculate implements ICalculateStrategy {

    @Override
    public Integer calculate(int num1, int num2) {
        return num1 + num2;
    }
}
