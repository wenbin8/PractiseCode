package com.wenbin.base.lambda.chapter3;

/**
 * @Auther: wenbin
 * @Date: 2018/12/19 15:23
 * @Description:
 */
public class TestLocalVariable {

    /**
     * 1,实例变量和局部变量背后的实现有一个关键的不同.实例变量存储在堆中,而局部变量则保存在
     * 栈上.如果lamdba可以直接访问局部变量,而且lambda是在一个线程中使用的,则使用lambda
     * 的线程,可能会再分配该变量的线程将这个变量收回之后,去访问该变量.因此,java在访问自由
     * 局部变量时,实际上是在访问它的副本,而不是访问原始变量.如果局部变量仅仅复制一次那就没
     * 什么区别了,因此有了这个限制.
     * 2,这一限制不鼓励你使用改变外部变量的典型命令式编程模式.
     * @param args
     */
    public static void main(String[] args) {
        // 局部变量
        int portNumber = 1377;
        Runnable r = () -> System.out.println(portNumber +"" + Thread.currentThread());
        // 会编译报错
//        portNumber=2220;
        Thread t = new Thread(r);
        t.start();


    }
}
