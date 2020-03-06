package com.demo.study.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找到数据流中第几大的数（小顶堆，最上面的数据是最小的） 703
 */
public class KthLargest2 {
    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

        for (int num : nums) {
            queue.offer(num);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{23, 12, 15, 67, 88, 99, 10, 18};
        KthLargest2 kthLargest = new KthLargest2(5, nums);
        // 堆顶的值就是数据流中第几大的数
        for (int i = 0; i < 5; i++) {
            System.out.println(kthLargest.queue.poll());
        }
    }
}
