package com.wenbin.base.thread.alarmAgent;



import java.util.Random;

/**
 * Created by wenbin on 2017/11/8.
 */
public class AlarmAgent {
    private final static AlarmAgent INSTANCE = new AlarmAgent();
    private final HeartbeartThread heartbeatThread = new HeartbeartThread();
    private boolean connectedToServer = false;

    private AlarmAgent() {

    }

    public static AlarmAgent getInstance() {
        return INSTANCE;
    }

    public void init() {
        connectToserver();
        heartbeatThread.setDaemon(true);
        heartbeatThread.start();
    }

    private void connectToserver() {
        new Thread() {
            @Override
            public void run() {
                doConnect();
            }
        }.start();
    }

    private void doConnect() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            connectedToServer = true;
            System.out.println("守护线程-重新建立连接成功,通知执行线程执行");
            notify();
        }
    }

    public void sendAlarm(String message) throws InterruptedException {
        synchronized (this) {
            while (!connectedToServer) {
                System.out.println("当前连接中断-挂起线程");
                wait();
            }
            doSendAlarm(message);
        }

    }

    private void doSendAlarm(String message) {
        System.out.print("Alarm send:" + message);

    }

    class HeartbeartThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                while (true) {
                    if (checkConnection()) {
                        connectedToServer = true;
                    } else {
                        connectedToServer = false;

                        System.out.println("守护线程-连接已断开");

                        connectToserver();
                    }
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private boolean checkConnection() {
            boolean isConnected = true;
            final Random random = new Random();

            int rand = random.nextInt(1000);
            if (rand <= 500) {
                isConnected = false;
            }
            System.out.println("连接状态: " + isConnected + " ");
            return isConnected;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        boolean isDaemon = Thread.currentThread().isDaemon();
        String threadName = Thread.currentThread().getName();


        AlarmAgent alarmAgent = AlarmAgent.getInstance();
        alarmAgent.init();
        for (int i=0; i < 100000000; i++) {

            alarmAgent.sendAlarm(String.valueOf(i));
        }
    }

}
