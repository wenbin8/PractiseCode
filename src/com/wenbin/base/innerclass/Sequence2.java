package com.wenbin.base.innerclass;

interface Selector2 {
    boolean end();

    Object current();

    void next();

    Sequence2 getOuter();
}
/**
 * Created by wenbin on 2017/11/20.
 */
public class Sequence2 {
    private Object[] items;
    private int next = 0;

    public Sequence2(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    public Selector2 selector() {
        return new SequenceSelector();
    }


    private class SequenceSelector implements Selector2 {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }

        public Sequence2 getOuter() {
            return Sequence2.this;
        }
    }

    public StringVO newStringVO(String str) {
        return new StringVO(str);
    }

    private class StringVO {
        private String str;

        StringVO(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return this.str;
        }

        public Sequence2 getOuter() {
            return Sequence2.this;
        }
    }


    public static void main(String args[]) {
        Sequence2 sequence2 = new Sequence2(10);

        for (int i= 0; i< 10; i++) {
//            sequence2.add(sequence2.newStringVO(String.valueOf(i)));
            // 可以通过外部类的实例对象使用.new关键字创建内部类的实例
            sequence2.add(sequence2.new StringVO(String.valueOf(i)));
        }

        Selector2 selector = sequence2.selector();

        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
        // 如方法getOuter中使用.this可以让内部类获取外部类的引用
        Sequence2 sequence21 = selector.getOuter();

        selector = sequence21.selector();

        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }



}
