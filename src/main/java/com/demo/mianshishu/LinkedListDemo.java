package com.demo.mianshishu;

/**
 * 查找倒数第k个节点
 * 当用一个指针不能解决问题时，尝试使用两个指针（链表的中间节点，两个指针，一个一次走一步，一个一次走两步）
 *
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        Node head = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);

        Node node = findKthToTail(head, 3);
        System.out.println(node);
    }

    public static Node findKthToTail(Node head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        Node node1 = head;
        for (int i = 0; i < k-1; i++) {
            if (node1.next != null) {
                node1 = node1.next;
            }
        }

        Node node2 = head;
        while(node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
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
