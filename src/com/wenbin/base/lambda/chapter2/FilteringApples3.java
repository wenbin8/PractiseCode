package com.wenbin.base.lambda.chapter2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: wenbin
 * @Date: 2018/12/17 22:17
 * @Description:
 */
public class FilteringApples3 {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green")
                , new Apple(155, "green")
                , new Apple(120, "red"));

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        inventory.forEach(apple -> System.out.println(apple.getColor() + ":" + apple.getWeight()));
        System.out.println("-----------------------------");

        inventory.sort((Apple a1, Apple a2) -> a2.getWeight().compareTo(a1.getWeight()));
        inventory.forEach(apple -> System.out.println(apple.getColor() + ":" + apple.getWeight()));
        System.out.println("-----------------------------");

        inventory.sort(Comparator.comparing(Apple::getWeight));
        inventory.forEach(apple -> System.out.println(apple.getColor() + ":" + apple.getWeight()));
        System.out.println("-----------------------------");

    }


}
