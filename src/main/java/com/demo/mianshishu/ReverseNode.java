package com.demo.mianshishu;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 */
public class ReverseNode {

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
        System.out.println(head);
        // head = reverse(head);
        // System.out.println(head);

        // Stack<String> stack = reverseNode(head);
        // while (!stack.isEmpty()) {
        //     System.out.println(stack.pop());
        // }
        // recursivePrint(head);
    }

    public static Stack<String> reverseNode(Node head) {
        Stack<String> stack = new Stack<>();
        while (head != null) {
            stack.add(head.value);
            head = head.next;
        }
        return stack;
    }

    public static void recursivePrint(Node head) {
        if (head != null) {
            recursivePrint(head.next);
            System.out.println(head.value);
        }

    }

    public static Node reverse(Node head) {
        Node cur = head;
        Node prev = null;

        while (cur != null) {
            Node tempNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNode;
        }
        return prev;
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

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
