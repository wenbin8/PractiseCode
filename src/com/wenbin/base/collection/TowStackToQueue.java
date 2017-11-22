package com.wenbin.base.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 用两个栈实现一个队列
 * Created by wenbin on 2017/11/22.
 */
public class TowStackToQueue<T> {
    // 缓存区(入队)
    private MyStack<T> s1 = new MyStack<T>();
    // 出队区
    private MyStack<T> s2 = new MyStack<T>();

    /**
     * 入队s1作为缓冲区
     * @param t
     */
    public void add(T t) {
        s1.push(t);

    }

    public List<T> poll() {
        // 出队区是否存在未出栈元素
        if (s1.isEmpty()) {
            return null;
        }

        List<T> list = new LinkedList<>();

        // 出队区是存在未出栈元素则将所有元素出栈
        if (!s2.isEmpty()) {
            for (int i = 0; i < s2.size(); i++) {
                list.add(s2.pop());
            }
        }

        // 将缓存区的元素出栈并入栈到出队区
        for (int i = 0; i <= s1.size(); i++) {
            s2.push(s1.pop());
        }

        // 将出队区出栈
        for (int i = 0; i <= s2.size(); i++) {
            list.add(s2.pop());
        }

        return list;
    }


    public static void main(String args[]) {
        TowStackToQueue<String> towStackToQueue = new TowStackToQueue<>();
        towStackToQueue.add("x1");
        towStackToQueue.add("x2");

        System.out.println(towStackToQueue.poll());

        towStackToQueue.add("x3");
        towStackToQueue.add("x4");

        System.out.println(towStackToQueue.poll());

        towStackToQueue.add("x5");
        towStackToQueue.add("x6");

        System.out.println(towStackToQueue.poll());

    }
}
