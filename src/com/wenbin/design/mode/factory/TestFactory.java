package com.wenbin.design.mode.factory;

import com.wenbin.design.mode.factory.entry.ITest;
import com.wenbin.design.mode.factory.entry.Junit;
import com.wenbin.design.mode.factory.entry.TestNG;

/**
 * Created by wenbin on 2017/9/26.
 */
public class TestFactory {

    public static ITest createInstance(String testType) {
        if ("1".equals(testType)) {
            return new TestNG();
        } else if ("2".equals(testType)) {
            return new Junit();
        }
        return null;
    }

    public static void main(String args[]) {
        ITest iTest = TestFactory.createInstance("1");
        iTest.test();

        iTest = TestFactory.createInstance("2");
        iTest.test();
    }
}
