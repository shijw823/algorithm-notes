package com.demo.important.shouxie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author shijianwei
 * @since 2019/03/26
 */
public class MyContainer3<T> {
    private List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        MyContainer3<Object> myContainer3 = new MyContainer3<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myContainer3.add("t-" + i);
                System.out.println("add-" + i);
                if (myContainer3.size() == 5) {
                    latch.countDown();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "thread-1");

        Thread t2 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread-2 end");
        }, "thread-2");

        t2.start();

        Thread.sleep(100);

        t1.start();

    }
}
