package com.wenbin.base.concurrency;

/**
 *
 * @author wenbin
 * @date 2017/12/10
 */
public class MoreBasicThreads1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
            System.out.println("Wating for LiftOff");
        }
    }
}
