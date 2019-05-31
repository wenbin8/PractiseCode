package com.wenbin.base.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: wenbin
 * @Date: 2019/4/2 10:47
 * @Description:
 */
public class ReentrantLockDemo {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        Object o1 = new Object();
        System.out.println(o1.toString());
        Object o2 = new Object();
        System.out.println(o2.toString());
        Object o3 = o1 = o2;
        System.out.println(o3.toString());


        ReentrantLockDemo lock = new ReentrantLockDemo();

        lock.put("1", "1");
        lock.put("2", "2");
        lock.get("2");

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (; ; ) {
            executorService.execute(() -> {
                String str = lock.get("1");
            });
        }

//        executorService.shutdown();
//        while (!executorService.isTerminated()) {
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }

    public void put(String key, String value) {
        reentrantLock.lock();
        map.put(key, value);
        reentrantLock.unlock();
    }

    public String get(String key) {
        reentrantLock.lock();
        System.out.println("线程:" + Thread.currentThread() + ",获得锁");
        String str = map.get(key);
        System.out.println("线程:" + Thread.currentThread() + ",获得数据:" + str);
        reentrantLock.unlock();
        return str;
    }

}
