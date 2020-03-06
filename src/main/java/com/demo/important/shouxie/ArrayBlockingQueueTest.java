package com.demo.important.shouxie;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author shijianwei
 * @since 2019/03/26
 */
public class ArrayBlockingQueueTest<T> {

    private ArrayBlockingQueue<T> queue = new ArrayBlockingQueue<>(100);

    private void add(T t) {
        try {
            queue.put(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private T get() {
        T t = null;
        try {
            t = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) {
        ArrayBlockingQueueTest arrayBlockingQueueTest = new ArrayBlockingQueueTest();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                arrayBlockingQueueTest.add("queue-" + i);
            }
        });
        t1.start();

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                while (true) {
                    arrayBlockingQueueTest.print(arrayBlockingQueueTest.get());
                }
            }, "thread-" + i);
        }

        for (int j = 0; j < 5; j++) {
            threads[j].start();
        }
    }

    private void print(T t) {
        System.out.println(Thread.currentThread().getName() + ":" + t);
    }
}
