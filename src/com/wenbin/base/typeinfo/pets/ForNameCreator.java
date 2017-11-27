//: typeinfo/pets/ForNameCreator.java
package com.wenbin.base.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();

    // Types that you want to be randomly created:
    private static String[] typeNames = {
            "com.wenbin.base.typeinfo.pets.Mutt",
            "com.wenbin.base.typeinfo.pets.Pug",
            "com.wenbin.base.typeinfo.pets.EgyptianMau",
            "com.wenbin.base.typeinfo.pets.Manx",
            "com.wenbin.base.typeinfo.pets.Cymric",
            "com.wenbin.base.typeinfo.pets.Rat",
            "com.wenbin.base.typeinfo.pets.Mouse",
            "com.wenbin.base.typeinfo.pets.Hamster"
    };

    static {
        // SuppressWarnings 无法注释在静态块上所以单独定义loader方法
        loader();
    }

    @SuppressWarnings("unchecked")
    private static void loader() {
        // 由于name参数是编译期无法验证正确性的所以这里需要处理运行时异常
        try {
            for (String name : typeNames){
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Class<? extends Pet>> types() {
        return types;
    }
} ///:~
