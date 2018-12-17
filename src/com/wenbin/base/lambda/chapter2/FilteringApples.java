package com.wenbin.base.lambda.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: wenbin
 * @Date: 2018/12/17 22:17
 * @Description:
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green")
                , new Apple(155, "green")
                , new Apple(120, "red"));

        List<Apple> heavyApples = filterApples(inventory, new ApplePredicateInterface() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });

        List<Apple> greenApples = filterApples(inventory, new ApplePredicateInterface() {
            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });


        heavyApples.forEach(apple -> System.out.println(apple.getWeight() + ":" + apple.getColor()));
        System.out.println("----------------------------");
        greenApples.forEach(apple -> System.out.println(apple.getWeight() + ":" + apple.getColor()));
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicateInterface p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

}
