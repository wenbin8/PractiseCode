package com.wenbin.base.concurrency;

/**
 * Created by wenbin on 2017/12/10.
 */
public class BasicThreads1 {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());

        t.start();
    }
}
