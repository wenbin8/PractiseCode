package com.wenbin.base.reflection;

public class myObject {

    private String name;
    private int age;

    public String info;


    public myObject() {

    }

    private myObject(String s) {

    }


    @Deprecated
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String value(int i) {
        return "";
    }
}
