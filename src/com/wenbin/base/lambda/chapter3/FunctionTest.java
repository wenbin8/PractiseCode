package com.wenbin.base.lambda.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @Auther: wenbin
 * @Date: 2018/12/18 23:05
 * @Description:
 */
public class FunctionTest {
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> l = map(Arrays.asList("lambda", "in", "action"), (String s) -> s.length());
        l.forEach(integer -> System.out.println(integer));
    }
}
