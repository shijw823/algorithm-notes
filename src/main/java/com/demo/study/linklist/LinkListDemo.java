package com.demo.study.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否为环
 */
public class LinkListDemo {

    public static void main(String[] args) {
        Node head = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node4);

        System.out.println(isCycle2(head));
    }

    public static boolean isCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<String> set = new HashSet<>();

        Node node = head.next;
        while (node != null) {
            if (!set.contains(node.value)) {
                set.add(node.value);
                node = node.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle2(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class Node {
        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
