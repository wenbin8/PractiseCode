package com.wenbin.base.lambda.chapter4;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: wenbin
 * @Date: 2018/12/19 20:12
 * @Description:
 */
public class MyStream {
    /**
     * 获取3种高热量的食物
     */
    public static void getHighCaloricDishNames() {
        List<String> highCaloricDishNames = DishList.menu.stream()  // 获得流
                .filter(dish -> dish.getCalories() > 300)// 断言筛选热量大于300的
                .map(Dish::getName)// 获得名称
                .limit(3)// 只取三条
                .collect(Collectors.toList());// 终端操作(及时求职),将流转换为新的集合.

        System.out.println(highCaloricDishNames);
    }

    /**
     * 将食物名称从集合中取出
     */
    public static void getDishName() {
        List<String> dishNameList = DishList.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(dishNameList);
    }

    /**
     * 获取3种高热量的食物
     */
    public static void getHighCaloricDishNames2() {
        List<String> highCaloricDishNames = DishList.menu.stream()  // 获得流
                .filter(dish -> {
                    System.out.println("filtering " + dish.getName());
                    return dish.getCalories() > 300;
                })// 断言筛选热量大于300的
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();
                })// 获得名称
                .limit(3)// 只取三条
                .collect(Collectors.toList());// 终端操作(及时求职),将流转换为新的集合.

    }

    public static void main(String[] args) {
       getHighCaloricDishNames();
       getDishName();
       getHighCaloricDishNames2();
    }
}
