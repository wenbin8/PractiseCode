package com.wenbin.design.mode;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * RecursiveTask 有返回值
 * @Auther: wenbin
 * @Date: 2019/6/4 21:36
 * @Description:
 */
public class ForkJoinSumCalulator extends RecursiveTask<Long>{

    /**
     * 要求和的数组
     */
    private final long[] numbers;
    /**
     * 子任务处理的数组的起始和终止位置
     */
    private final int start;
    private final int end;

    /**
     * 不在将任务分解为子任务的数组大小
     */
    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalulator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public ForkJoinSumCalulator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // 当前任务负责计算的大小
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSeequentially();
        }

        ForkJoinSumCalulator left =
                new ForkJoinSumCalulator(numbers, start, start + length / 2);
        // 将这个任务推送给线程池,启动线程去执行
        left.fork();
        ForkJoinSumCalulator right = new ForkJoinSumCalulator(numbers, start + length / 2, end);

        // 当前线程同步执行
        Long rightResult = right.compute();
        // 阻塞等待该线程执行完成
        Long leftResult = left.join();

        return rightResult + leftResult;
    }

    private long computeSeequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 100000).toArray();
        ForkJoinSumCalulator task = new ForkJoinSumCalulator(numbers);
        long sum = new ForkJoinPool().invoke(task);
        System.out.println(sum);

    }
}
