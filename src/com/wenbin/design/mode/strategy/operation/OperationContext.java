package com.wenbin.design.mode.strategy.operation;

import com.wenbin.design.mode.strategy.operation.entry.AddCalculate;
import com.wenbin.design.mode.strategy.operation.entry.ICalculateStrategy;
import com.wenbin.design.mode.strategy.operation.entry.SubtractCalculate;

/**
 * Created by wenbin on 2017/9/26.
 */
public class OperationContext {
    ICalculateStrategy calculate = null;

    public OperationContext(ICalculateStrategy calculate) {
        this.calculate = calculate;
    }

    public int getResult(int num1, int num2) {
        return calculate.calculate(num1, num2);
    }

    public static void main(String[] args) {
        ICalculateStrategy iCalculateStrategy = new AddCalculate();

        OperationContext operationContext = new OperationContext(iCalculateStrategy);
        int num = operationContext.getResult(150, 100);

        System.out.println("Add:" + num);

        iCalculateStrategy = new SubtractCalculate();

        operationContext = new OperationContext(iCalculateStrategy);
        num = operationContext.getResult(150, 100);

        System.out.println("Sub:" + num);

    }
}
