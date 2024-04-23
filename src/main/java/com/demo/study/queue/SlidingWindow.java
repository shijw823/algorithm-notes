package com.demo.study.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * *********************ok
 * 滑动窗口最大值 O(n) 239
 * 难
 *
 * 可以采用优先队列， 大顶堆，O(nlogk)
 */
public class SlidingWindow {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        SlidingWindow slidingWindow = new SlidingWindow();
        int[] result = slidingWindow.maxSlidingWindow(arr, k);
        for (int item : result) {
            System.out.println(item);
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        int j = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (i + 1 >= k) {
                res[j++] = queue.peek();
            }
            if (i >= k) {
                queue.remove(nums[i-k]);
            }
        }
        System.out.println("queue:" + queue);
        return res;
    }

    // 每次加入一个元素下标，加入前判断，如果队列不为空且元素小于要加入的元素，则删除之前的所有小的元素
    // 队列中左边的永远是最大的
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 删除队列中小于窗口左边下标的元素
            // 保留k个元素
            if (i >= k && i - k + 1 > deque.peek()) {
                deque.remove();
            }

            // 从队列右侧开始, 删除小于nums[i] 的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.add(i);

            // 队列左侧是最大值,加入结果
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }
}
