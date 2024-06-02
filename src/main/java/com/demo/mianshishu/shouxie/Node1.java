package com.demo.mianshishu.shouxie;

/**
 * *********************ok
 * 删除链表的节点
 * 要求是O(1)
 *
 * 136
 *
 */
public class Node1 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

         head.setNext(node2);
         node2.setNext(node3);
         node3.setNext(node4);
         node4.setNext(node5);
         node5.setNext(node6);

        head = deleteNode(head, 4);
        System.out.println(head);
    }

    public static Node deleteNode(Node head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        Node cur = head;
        while(cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
