package com.wenbin.design.mode.strategy.operation;

/**
 * Created by wenbin on 2017/9/26.
 */
public class OperationContext {
    ICalculateStrategy calculate = null;
    public OperationContext(char flag) {
        calculate = CalculateFactory.createInstance(flag);
    }

    public int getResult(int num1, int num2) {
        return calculate.calculate(num1, num2);
    }

    public static void main(String[] args) {
        OperationContext AddContext = new OperationContext('+');
        int result = AddContext.getResult(100, 150);

        System.out.println("Add:" + result);

        OperationContext SubContext = new OperationContext('-');
        result = SubContext.getResult(100, 150);

        System.out.println("sub:" + result);
    }
}
