package com.wenbin.base.collection;

import java.util.LinkedList;

/**
 * Created by wenbin on 2017/11/22.
 *     pop()--弹栈
 *     push()--压栈
 *     peek()--返回栈顶元素
 *     isEmpty()--栈是否为空
 */
public class MyStack<T> {
    private LinkedList<T> stackList = new LinkedList<T>();

    /**
     * 弹栈
     */
    public T pop() {
        return stackList.removeFirst();
    }

    /**
     * 压栈
     * @param entry 栈元素
     */
    public void push(T entry) {
        stackList.addFirst(entry);
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public T peek() {
        return stackList.getFirst();
    }

    /**
     * 栈是否为空
     * @return 空 true
     */
    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public int size() {
        return stackList.size();
    }


    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println("栈顶:"+stack.peek());
        System.out.println("出栈:"+stack.pop());
        System.out.println("是否为空:"+stack.isEmpty());

        System.out.println("栈顶:"+stack.peek());
        System.out.println("出栈:"+stack.pop());
        System.out.println("是否为空:"+stack.isEmpty());

        System.out.println("栈顶:"+stack.peek());
        System.out.println("出栈:"+stack.pop());
        System.out.println("是否为空:"+stack.isEmpty());


    }
}
