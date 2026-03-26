package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/30
 * https://leetcode.cn/problems/rotate-array/
 */
public class RotateTest {

    // 时间复杂度：O(n)， 空间复杂度：O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // 处理k大于数组长度的情况

        // 如果k=0，不需要旋转
        if (k == 0) {
            return;
        }

        // 三次反转
        reverse(nums, 0, n - 1); // 反转整个数组
        reverse(nums, 0, k - 1); // 反转前k个元素
        reverse(nums, k, n - 1); // 反转剩余元素
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end++;
        }
    }
}
