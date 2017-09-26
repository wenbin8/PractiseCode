package com.wenbin.design.mode.strategy.operation;

/**
 * Created by wenbin on 2017/9/26.
 */
public class SubtractCalculate implements ICalculateStrategy {
    @Override
    public Integer calculate(int num1, int num2) {
        return num1 - num2;
    }
}
