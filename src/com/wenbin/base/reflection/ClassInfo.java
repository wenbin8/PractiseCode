package com.wenbin.base.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassInfo {
    public static void main(String[] args) throws ClassNotFoundException {
        String className = "com.wenbin.base.reflection.myObject";
        //
        Class clazz = Class.forName(className);

        // 获得构造函数
        Constructor[] constructors = clazz.getConstructors();
        System.out.println("1构造函数------------------------------");
        printConstructor(constructors);

        Constructor[] constructors1 = clazz.getDeclaredConstructors();
        System.out.println("2构造函数------------------------------");
        printConstructor(constructors1);

        // 获得类名
        System.out.println(clazz.getSimpleName());
        // 获得成员变量
        Field[] fields = clazz.getFields();
        System.out.println("1属性------------------------------");
        printField(fields);
        Field[] fields1 = clazz.getDeclaredFields();
        System.out.println("2属性------------------------------");
        printField(fields1);
        // 获得方法
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("1方法----------class内声明的方法");
        printMethods(methods);
        System.out.println("2方法----------class所有关联方法");
        Method[] methods1 = clazz.getMethods();
        printMethods(methods1);

    }

    private static void printConstructor(Constructor[] constructors) {
        for (Constructor constructor : constructors) {
            String info = constructor.getName() + " ";
            System.out.print(info + "(");

            Class [] classes = constructor.getParameterTypes();

            for (Class clszz : classes) {
                System.out.print(clszz.getSimpleName()+",");

            }
            System.out.print(") \n");

        }
    }

    private static void printField(Field[] fields) {
        for (Field field : fields) {
            String info = field.getType() + " " + field.getName();
            System.out.println(info);
        }
    }

    private static void printMethods(Method[] methods) {
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
            }

            System.out.print(method.getReturnType()+" "+ method.getName() + " (");
            Class[] pClazzs = method.getParameterTypes();
            for (Class clzz : pClazzs) {
                System.out.print(clzz.getSimpleName() + ",");
            }

            System.out.print(") \n");
        }
    }
}
