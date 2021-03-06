package com.demo.study.heap;

import java.util.PriorityQueue;

/**
 * 找到数据流中第几大的数（小顶堆，最上面的数据是最小的） 703
 */
public class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);

        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            // 堆的数量还未达到k时
            queue.offer(val);
        } else if (queue.peek() < val) {
            // 堆顶的最小值小于新添加进来的数据，会剔除掉堆顶的最小值，把新数据放进去
            queue.poll();
            queue.offer(val);
        }
        // 返回堆顶的值
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{23, 12, 15, 67, 88, 99, 10, 18};
        KthLargest kthLargest = new KthLargest(5, nums);
        // 堆顶的值就是数据流中第几大的数
        System.out.println(kthLargest.queue.peek());
    }
}
