package com.wenbin.base.io;//: io/BufferedInputFile.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 中文注释. 字符形式读取
public class BufferedInputFile {
    // Throw exceptions to console:
    public static String read(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(read("/Users/wenbin/code/PractiseCode/src/com/wenbin/base/io/BufferedInputFile.java"));
    }
} /* (Execute to see output) *///:~
