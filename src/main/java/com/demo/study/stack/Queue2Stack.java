package com.demo.study.stack;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 使用队列实现栈功能 225
 */
public class Queue2Stack {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top()); // returns 3
        System.out.println(stack.pop());   // returns 3
        System.out.println(stack.pop());
        System.out.println(stack.empty()); // returns false

    }

    static class MyStack {
        ConcurrentLinkedQueue<Integer> inputQueue = new ConcurrentLinkedQueue<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            inputQueue.offer(x);
            // 1,2,3
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (!inputQueue.isEmpty()) {
                Iterator<Integer> iterator = inputQueue.iterator();
                Integer result = null;
                while (iterator.hasNext()) {
                    result = iterator.next();
                }

                inputQueue.remove(result);
                // 1，2

                return result;
            }
            return -1;
        }

        /** Get the top element. */
        public int top() {
            if (!inputQueue.isEmpty()) {
                Iterator<Integer> iterator = inputQueue.iterator();
                Integer result = null;
                while (iterator.hasNext()) {
                    result = iterator.next();
                }

                return result;
            }
            return -1;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return inputQueue.isEmpty();
        }
    }
}
