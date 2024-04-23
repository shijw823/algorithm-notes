package com.demo.mianshishu;

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

        head = deleteNode2(head, 4);
        System.out.println(head);
    }

    public static Node deleteNode(Node head, int val) {
        //边界条件判断
        if (head == null) {
            return head;
        }
        //如果要删除的是头结点，直接返回头结点的下一个结点即可
        if (head.val == val) {
            return head.next;
        }
        Node cur = head;
        //找到要删除结点的上一个结点
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        //删除结点
        cur.next = cur.next.next;
        return head;
    }

    public static Node deleteNode2(Node head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNode2(head.next, val);
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
