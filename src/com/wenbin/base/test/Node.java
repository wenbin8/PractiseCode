package com.wenbin.base.test;

/**
 * @Auther: wenbin
 * @Date: 2018/10/18 14:37
 * @Description:
 */
public class Node {
    public Node next;

    public String name;


    public static void main(String[] args) {
        Node node1 = new Node();
        node1.name="node1";
        Node node2 = new Node();
        node2.name="node2";
        node1.next = node2;
        Node node3 = new Node();
        node3.name="node3";
        node2.next = node3;

        Node node4 = new Node();
        node4.name="node4";
        node3.next = node4;

//        Node node = LinkTest.reveseList(node1);

        Node n = LinkTest.reverse(node1);

        boolean b = n.next != null ;
//        Node n = node4;
        while (b) {
            b = n.next != null;
            System.out.println(n.name);
            n = n.next;
        }

    }

}
