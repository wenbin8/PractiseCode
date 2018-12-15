package com.wenbin.base.reflection;

import java.lang.reflect.Method;

public class ReflectionHelloWord {

    public static void main(String[] args) {
        Method[] methods = Object.class.getMethods();

        for (Method method : methods) {
            System.out.println("method=" + method.getName());

            System.out.println("ReturnType=" + method.getReturnType());
//            method.get
        }
    }
}
