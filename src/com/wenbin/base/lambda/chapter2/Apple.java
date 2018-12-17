package com.wenbin.base.lambda.chapter2;

/**
 * @Auther: wenbin
 * @Date: 2018/12/17 22:15
 * @Description:
 */
public class Apple {
    public Integer weight;
    public String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
