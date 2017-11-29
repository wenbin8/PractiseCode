package com.wenbin.base.containers;

import java.util.LinkedList;

/**
 * Created by wenbin on 2017/11/28.
 */
public class MyLinkedList<E> {

    transient int size;

    transient Node<E> first;

    transient Node<E> last;

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add (E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }


    public static void main(String args[]) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("c");
        myLinkedList.add("b");


    }
}
