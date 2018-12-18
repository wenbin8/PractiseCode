package com.wenbin.base.lambda.chapter3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Auther: wenbin
 * @Date: 2018/12/18 22:28
 * @Description:
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}
