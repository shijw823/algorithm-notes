package com.demo.important;

/**
 * 用环来实现队列
 */
public class MyQueue {
    private static final int maxQueueSize = 5;
    private Node head;
    private Node tailNode;
    private int count;

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.head = myQueue.initQueue();

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.remove();
        myQueue.add(6);
        myQueue.remove();
        myQueue.add(7);
        myQueue.add(8);


        Node current = myQueue.head;
        for (int i = 0; i < maxQueueSize; i++) {
            System.out.println(current.getValue());
            current = current.getNext();
        }

    }

    private Node initQueue() {
        head = new Node(null);
        tailNode = head;
        for (int i = 0; i < maxQueueSize - 1; i++) {
            Node tempNode = new Node(null);
            tailNode.setNext(tempNode);
            tailNode = tempNode;
        }
        tailNode.setNext(head);
        tailNode = head;
        return head;
    }

    public void add(int value) {
        if (tailNode.getValue() == null) {
            tailNode.setValue(value);
            tailNode = tailNode.getNext();
        }
    }

    public Integer remove() {
        Integer value = head.getValue();
        if (value != null) {
            head.setValue(null);
            tailNode = head;
            head = head.getNext();
            return value;
        }
        return null;
    }


    static class Node {
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
