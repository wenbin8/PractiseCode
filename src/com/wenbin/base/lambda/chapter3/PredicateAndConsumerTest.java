package com.wenbin.base.lambda.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Auther: wenbin
 * @Date: 2018/12/18 22:49
 * @Description:
 */
public class PredicateAndConsumerTest {
    public static <T> List<T> filter(List<T> list, java.util.function.Predicate<T> p) {
        List<T> results = new ArrayList<>();

        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicat = (String s) -> !s.isEmpty();

        List<String> stringList = new ArrayList<>();
        stringList.add("");
        stringList.add("asdf");
        stringList.add("jkjklj");

        List<String> nonEmpty = filter(stringList, nonEmptyStringPredicat);

        // lambda表达式:表达了函数是接口内唯一抽象方法的方法实现
        Consumer<String> consumer = s -> System.out.println(s);
        nonEmpty.forEach(consumer);
    }
}
