package com.wenbin.base.jvm;

/**
 * Created by wenbin on 2017/11/16.
 */
public class DumpTest {
    // JVM参数 -Xmx40m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=dump
    public static void main(String[] args) {
        long arr[];
        for (int i=1; i<=10000000; i*=2) {
            arr = new long[i];
        }
    }
}
