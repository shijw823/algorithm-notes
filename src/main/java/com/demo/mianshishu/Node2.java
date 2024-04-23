package com.demo.mianshishu;

/**
 * *********************ok
 * 两个递增链表，进行合并，合并后的链表是递增的
 * 要求是O(1)
 */
public class Node2 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        node1.setNext(node3);
        node3.setNext(node5);


        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node6 = new Node(6);
        node2.setNext(node4);
        node4.setNext(node6);

        Node mergeNode = merge(node1, node2);
        System.out.println(mergeNode);
    }

    public static Node merge(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }
        Node mergeNode = null;
        if (node1.value < node2.value) {
            mergeNode = node1;
            mergeNode.next = merge(node1.next, node2);
        } else {
            mergeNode = node2;
            mergeNode.next = merge(node1, node2.next);
        }

        return mergeNode;
    }

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
