package com.demo.study.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值 O(n) 239
 * ???
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

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 删除队列中小于窗口左边下标的元素
            if (i >= k && deque.peek() <= i - k) {
                deque.remove();
            }

            // 从队列右侧开始, 删除小于nums[i] 的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }

            deque.add(i);

            // 队列左侧是最大值,加入结果
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }
}
