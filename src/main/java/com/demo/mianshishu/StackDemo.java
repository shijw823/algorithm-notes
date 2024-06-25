package com.demo.mianshishu;

import java.util.Stack;

/**
 * *********************ok
 * 栈的最小值函数，push，pop，要求时间复杂度都是O(1)
 *
 */
public class StackDemo {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo();
        stackDemo.push(3);
        System.out.println(stackDemo.min() + " -> " + stackDemo.stack.size() + ":" + stackDemo.minStack.size());
        stackDemo.push(4);
        System.out.println(stackDemo.min() + " -> " + stackDemo.stack.size() + ":" + stackDemo.minStack.size());
        stackDemo.push(2);
        System.out.println(stackDemo.min() + " -> " + stackDemo.stack.size() + ":" + stackDemo.minStack.size());
        stackDemo.push(1);
        System.out.println(stackDemo.min() + " -> " + stackDemo.stack.size() + ":" + stackDemo.minStack.size());
        stackDemo.pop();
        System.out.println(stackDemo.min() + " -> " + stackDemo.stack.size() + ":" + stackDemo.minStack.size());
        stackDemo.pop();
        System.out.println(stackDemo.min() + " -> " + stackDemo.stack.size() + ":" + stackDemo.minStack.size());
        stackDemo.push(0);
        System.out.println(stackDemo.min() + " -> " + stackDemo.stack.size() + ":" + stackDemo.minStack.size());
    }

    public void push(int value) {
        stack.push(value);

        if (!minStack.isEmpty() && minStack.peek() < value) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(value);
        }
    }

    public void pop() {
        if (!stack.isEmpty() && !minStack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int min() {
        if (!stack.isEmpty() && !minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }
}
