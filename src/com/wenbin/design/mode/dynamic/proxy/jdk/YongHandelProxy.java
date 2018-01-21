package com.wenbin.design.mode.dynamic.proxy.jdk;

import com.wenbin.base.value.ObjectValueTransmitTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wenbin on 2018/1/21.
 */
public class YongHandelProxy implements InvocationHandler {

    private Object target;

    public YongHandelProxy(Object target) {
        this.target = target;
    }


    @Override

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//        System.out.println("proxy:" + proxy);
        System.out.println("method:" + method);
        System.out.println("args:" + args);

        System.out.println("代理方法调用之前.");

        Object returnValue = method.invoke(target, args);

        System.out.println("代理方法调用之后");

        return returnValue;
    }
}
