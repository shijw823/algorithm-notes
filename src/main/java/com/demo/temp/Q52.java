package com.demo.temp;

/**
 * **********************??
 * 找出两个链表中的第一个公共节点
 *
 */
public class Q52 {
    public static void main(String[] args) {
        Q52 demo = new Q52();
        Node head = new Node("4");
        Node node11 = new Node("5");
        Node node12 = new Node("3");
        Node node13 = new Node("6");
        Node node14 = new Node("7");

        head.setNext(node11);
        node11.setNext(node12);
        node12.setNext(node13);
        node13.setNext(node14);

        System.out.println(head);

        Node head2 = new Node("4");
        Node node21 = new Node("5");
        head2.setNext(node21);
        node21.setNext(node14);

        System.out.println(head2);

        Node firstCommonNode = demo.getFirstCommonNode(head, head2);
        System.out.println(firstCommonNode);
    }

    public Node getFirstCommonNode(Node head1, Node head2) {
        int len1 = getNodeLength(head1);
        int len2 = getNodeLength(head2);

        int diff = 0;
        if (len1 > len2) {
            diff = len1 - len2;
            for (int i = 0; i < diff; i++) {
                head1 = head1.next;
            }
        } else {
            diff = len2 - len1;
            for (int i = 0; i < diff; i++) {
                head2 = head2.next;
            }
        }

        System.out.println("diff=" + diff);

        while(head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    public int getNodeLength(Node head) {
        int len = 0;
        Node node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
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
