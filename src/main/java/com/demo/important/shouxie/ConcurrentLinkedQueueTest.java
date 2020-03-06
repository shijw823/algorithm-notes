package com.demo.important.shouxie;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author shijianwei
 * @since 2019/03/26
 */
public class ConcurrentLinkedQueueTest {
    private static Queue<String> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.add("ticket-"+i);
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String ele = queue.poll();
                    if(ele == null) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + " get ticket=" + ele);
                }
            }).start();
        }
    }
}
