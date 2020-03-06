package com.demo.important.shouxie;

import java.util.LinkedList;

/**
 * @author shijianwei
 * @since 2019/03/26
 */
public class MyContainer<T> {

    private LinkedList<T> list = new LinkedList<>();
    private static int capacity = 10;
    private int count = 0;


    public synchronized void put(T t) {
        while(list.size() >= capacity) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(t);
        count++;
        this.notifyAll();

    }

    public synchronized T get() {
        while(list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        T t = list.removeFirst();
        this.notifyAll();
        return t;
    }
}
