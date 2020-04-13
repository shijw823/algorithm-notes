package com.demo.mianshishu;

/**
 * 删除链表的节点
 * 要求是O(1)
 *
 */
public class Node1 {
    public static void main(String[] args) {
        Node head = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");

        // head.setNext(node2);
        // node2.setNext(node3);
        // node3.setNext(node4);
        // node4.setNext(node5);
        // node5.setNext(node6);

        delNode(head, head);
        System.out.println(head);
    }

    public static void delNode(Node head, Node delNode) {
        // 把要删除的节点的下一个节点的值赋值给删除节点
        // 相当于删除节点和删除节点的下一个节点一样，然后变化指针，删除要删除节点的下一个节点
        if (delNode.next != null) {
            delNode.value = delNode.next.value;
            delNode.next = delNode.next.next;
        } else if (head == delNode) {
            delNode = null;
            head = null;
        }
        // 链表中有多个节点，删除尾节点，从头遍历
        else {
            Node node = head;
            while (node != null) {
                if (node.next == delNode) {
                    node.next = null;
                } else {
                    node = node.next;
                }
            }
        }
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
