package com.wenbin.base.lambda.chapter4;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: wenbin
 * @Date: 2018/12/19 20:07
 * @Description:
 */
public class DishList {
    public static List<Dish> menu = Arrays.asList(
      new Dish("pork", false, 800, Dish.Type.MEAT),
      new Dish("beef", false, 700, Dish.Type.MEAT),
      new Dish("chicken", false, 400, Dish.Type.MEAT),
      new Dish("french fries", true, 530, Dish.Type.OHTER),
      new Dish("rice", true, 350, Dish.Type.OHTER),
      new Dish("season fruit", true, 120, Dish.Type.OHTER),
      new Dish("pizza", true, 550, Dish.Type.OHTER),
      new Dish("prawna", false, 300, Dish.Type.FISH),
      new Dish("salmon", false, 450, Dish.Type.FISH)
    );
}
