package com.wenbin.base.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: wenbin
 * @Date: 2019/4/3 17:25
 * @Description:
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(()->{
            countDownLatch.countDown();
        }, "t1").start();

        new Thread(()->{
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }, "t2").start();

        new Thread(()->{
            countDownLatch.countDown();
        }, "t3").start();

        new Thread(()->{
            try {
                countDownLatch.await();
                System.out.println("t4 唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t4").start();

        countDownLatch.await();
        System.out.println("main 唤醒");

        // 唤醒顺序 t2唤醒main main唤醒t4    t2->main->t4

    }
}
