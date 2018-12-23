package com.wenbin.base.lambda.chepter5;

/**
 * @Auther: wenbin
 * @Date: 2018/12/23 11:19
 * @Description:
 */
public class Value {
    String key;

    int number;


    public Value(String key, int number) {
        this.key = key;
        this.number = number;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Value{" +
                "key='" + key + '\'' +
                ", number=" + number +
                '}';
    }
}
