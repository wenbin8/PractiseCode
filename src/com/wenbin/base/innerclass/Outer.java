package com.wenbin.base.innerclass;

/**
 * Created by wenbin on 2017/11/20.
 * 内部类:如果想从外部类的非静态方法之外的任意位置创建某个内部类对象,那么必须具体指明这个对象的类型:Outer.Inner
 */
public class Outer {
    Inner getInner() {
        return new Inner("abc");
    }

    class Inner {
        private String name;

        Inner(String name) {
            this.name = name;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.getInner();

        System.out.println(inner.getName());

        inner.setName("ccc");

        System.out.println(inner.getName());

//        outer.Inner.

    }
}
