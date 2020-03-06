package com.demo;

import java.util.PriorityQueue;

/**
 * 最大的5个数
 */
public class TopK {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((i,j) -> j -i);

        queue.offer(5);
        queue.offer(3);
        queue.offer(7);
        queue.offer(1);
        queue.offer(8);
        queue.offer(2);
        queue.offer(9);
        queue.offer(4);
        queue.offer(7);
        queue.offer(2);
        queue.offer(6);
        queue.offer(6);


        for (int i = 0; i < 5; i++) {
            System.out.println(queue.poll());
        }
    }

}
