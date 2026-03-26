package com.demo.practice;

import java.util.Arrays;

/**
 * @author shijianwei
 * @date 2025/12/30
 * https://leetcode.cn/problems/merge-sorted-array/
 */
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后向前合并，避免覆盖nums1中的元素
        int i = m - 1;  // nums1的有效元素末尾
        int j = n - 1;  // nums2的末尾
        int k = m + n - 1;  // 合并后的数组末尾

        // 从后向前遍历，将较大的元素放到nums1的末尾
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // 如果nums2中还有剩余元素，直接复制到nums1前面
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        // 注意：nums1中剩余的元素已经在正确的位置，不需要处理
    }

    public static void main(String[] args) {
        MergeArray solution = new MergeArray();

        // 测试用例1
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println("测试用例1: " + Arrays.toString(nums1));
        // 输出: [1, 2, 2, 3, 5, 6]

        // 测试用例2
        int[] nums3 = new int[]{4, 5, 6, 0, 0, 0};
        int[] nums4 = new int[]{1, 2, 3};
        solution.merge(nums3, 3, nums4, 3);
        System.out.println("测试用例2: " + Arrays.toString(nums3));
        // 输出: [1, 2, 3, 4, 5, 6]

        // 测试用例3
        int[] nums5 = new int[]{1, 0, 0, 0};
        int[] nums6 = new int[]{2, 3, 4};
        solution.merge(nums5, 1, nums6, 3);
        System.out.println("测试用例3: " + Arrays.toString(nums5));
        // 输出: [1, 2, 3, 4]
    }
}
