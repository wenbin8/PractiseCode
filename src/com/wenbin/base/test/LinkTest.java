package com.wenbin.base.test;

/**
 * @Auther: wenbin
 * @Date: 2018/10/18 14:38
 * @Description:
 */
public class LinkTest {

    public static Node reveseList(Node node) {
        if (node.next == null) {
            return node;
        } else {
            Node n = reveseList(node.next);
            n.next = node;
            node.next = null;

            return node;
        }
    }

    public static Node reverse(Node list) {
        Node headNode = null;

        Node previousNode = null;
        Node currentNode = list;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return headNode;
    }
}
