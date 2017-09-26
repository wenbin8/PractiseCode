package com.wenbin.design.mode.strategy.operation;

import com.wenbin.design.mode.strategy.operation.entry.ICalculateStrategy;

/**
 * Created by wenbin on 2017/9/26.
 */
public class OperationAndFactoryContext {
    ICalculateStrategy calculate = null;
    public OperationAndFactoryContext(char flag) {
        calculate = CalculateFactory.createInstance(flag);
    }

    public int getResult(int num1, int num2) {
        return calculate.calculate(num1, num2);
    }

    public static void main(String[] args) {
        OperationAndFactoryContext AddContext = new OperationAndFactoryContext('+');
        int result = AddContext.getResult(100, 150);

        System.out.println("Add:" + result);

        OperationAndFactoryContext SubContext = new OperationAndFactoryContext('-');
        result = SubContext.getResult(100, 150);

        System.out.println("sub:" + result);
    }
}
