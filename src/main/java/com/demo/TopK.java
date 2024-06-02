package com.demo;

import com.demo.study.heap.KthLargest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 最大的5个数
 * @see KthLargest
 */
public class TopK {

    public static void main(String[] args) {
        // 从大到小
        PriorityQueue<Integer> queue = new PriorityQueue<>((i,j) -> j-i);

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

        //System.out.println(queue.size());
        //int size = queue.size();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            resultList.add(queue.poll());
        }
        System.out.println(resultList);
    }

}
