package com.demo.study.stack;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * *********************
 * 使用队列实现栈功能 225
 * ？？？
 */
public class Queue2Stack {

    public static void main(String[] args) {


    }

    class MyStack {
        ConcurrentLinkedQueue<Integer> inputQueue = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedQueue<Integer> outputQueue = new ConcurrentLinkedQueue<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (!inputQueue.isEmpty()) {
                outputQueue.offer(x);
                Iterator<Integer> iterator = inputQueue.iterator();
                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    outputQueue.offer(next);
                }
                inputQueue.clear();
            }
            inputQueue.offer(x);


        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (!outputQueue.isEmpty()) {
                Iterator<Integer> iterator = outputQueue.iterator();
                Integer result = null;
                while (iterator.hasNext()) {
                    result = iterator.next();
                }

                outputQueue.remove(result);

                return result;
            }
            return -1;
        }

        /** Get the top element. */
        public int top() {
            if (!outputQueue.isEmpty()) {
                Iterator<Integer> iterator = outputQueue.iterator();
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
            return outputQueue.isEmpty();
        }
    }
}
