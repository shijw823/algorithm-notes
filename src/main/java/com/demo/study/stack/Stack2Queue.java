package com.demo.study.stack;

import java.util.Stack;

/**
 * 使用栈实现队列功能 232
 */
public class Stack2Queue {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);


        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println("------------");

        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.empty());

        System.out.println(myQueue.pop());
        System.out.println("------------");
        myQueue.push(6);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println("------------");
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    static class MyQueue {
        // 输入栈，负责入队
        Stack<Integer> inputStack = new Stack<>();
        // 输出栈，负责出队
        Stack<Integer> outputStack = new Stack<>();

        /**
         * 模拟队列获取数据
         *
         * @return 数据
         */
        public Integer peek() {

            if (!outputStack.isEmpty()) {
                return outputStack.peek();
            }

            while(!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }

            if (outputStack.isEmpty()) {
                return null;
            }

            return outputStack.peek();
        }

        /**
         * 模拟队列入队
         *
         * @param data 入队数据
         */
        public void push(Integer data) {
            inputStack.push(data);
        }

        /**
         * 模拟队列出队
         *
         * @return 出队数据
         */
        public Integer pop() {

            if (!outputStack.isEmpty()) {
                return outputStack.pop();
            }

            while(!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }

            if (outputStack.isEmpty()) {
                return null;
            }

            return outputStack.pop();
        }

        public boolean empty() {
            if (!outputStack.isEmpty() || !inputStack.isEmpty()) {
                return false;
            }

            return true;
        }
    }
}
