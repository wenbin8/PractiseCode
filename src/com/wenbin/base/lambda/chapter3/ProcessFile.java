package com.wenbin.base.lambda.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Auther: wenbin
 * @Date: 2018/12/18 22:31
 * @Description:
 */
public class ProcessFile {
    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/wenbin/log/awk/awk_copy.log"))){
            return processor.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Thread.currentThread());
        String oneLine = processFile((BufferedReader br) -> br.readLine()+ ":" + Thread.currentThread());
        System.out.println(oneLine);
        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine()+ ":" + Thread.currentThread());
        System.out.println(twoLines);
    }
}
