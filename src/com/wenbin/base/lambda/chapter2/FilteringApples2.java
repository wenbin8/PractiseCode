package com.wenbin.base.lambda.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: wenbin
 * @Date: 2018/12/17 22:17
 * @Description:
 */
public class FilteringApples2 {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green")
                , new Apple(155, "green")
                , new Apple(120, "red"));

        List<Apple> heavyApples = filterApples(inventory, (Apple apple) -> apple.getWeight() > 150);

        List<Apple> greenApples = filterApples(inventory, (Apple apple) -> "green".equals(apple.getColor()));


        heavyApples.forEach(apple -> System.out.println(apple.getWeight() + ":" + apple.getColor()));
        System.out.println("----------------------------");
        greenApples.forEach(apple -> System.out.println(apple.getWeight() + ":" + apple.getColor()));
    }

    public static <T> List<T> filterApples(List<T> inventory, ApplePredicateInterface2<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : inventory) {
            if (p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

}
