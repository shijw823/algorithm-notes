package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/30
 */
public class RemoveDuplicates {
    // 时间复杂福O(n),空间复杂度O(1)

    /**
     * 算法思路：
     * 双指针方法：
     *
     * slow 指针：指向当前不重复序列的最后一个位置
     *
     * fast 指针：遍历整个数组
     *
     * 执行过程：
     *
     * 初始化 slow = 0
     *
     * 从 fast = 1 开始遍历数组
     *
     * 如果 nums[fast] != nums[slow]，说明找到了一个新的不重复元素
     *
     * 将 slow 指针右移一位，并将 nums[fast] 的值赋给 nums[slow]
     *
     * 最后返回 slow + 1，即不重复元素的个数
     *
     * 原始数组: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
     * 处理过程:
     * slow=0, fast=1: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] (相同，fast++)
     * slow=0, fast=2: [0, 1, 1, 1, 1, 2, 2, 3, 3, 4] (不同，slow++, 赋值)
     * slow=1, fast=3: [0, 1, 1, 1, 1, 2, 2, 3, 3, 4] (相同，fast++)
     * slow=1, fast=4: [0, 1, 1, 1, 1, 2, 2, 3, 3, 4] (相同，fast++)
     * slow=1, fast=5: [0, 1, 2, 1, 1, 2, 2, 3, 3, 4] (不同，slow++, 赋值)
     * ...
     * 最终结果: [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]，返回长度5
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0; // 慢指针，用于记录不重复元素的位置

        // 快指针遍历整个数组
        for (int fast = 1; fast < nums.length; fast++) {
            // 当快指针指向的元素与慢指针指向的元素不同时
            if (nums[fast] != nums[slow]) {
                slow++; // 移动慢指针
                nums[slow] = nums[fast]; // 更新不重复元素
            }
        }

        return slow + 1; // 返回不重复元素的个数
    }

    // 测试代码
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int len1 = removeDuplicates(nums1);
        System.out.print("不重复元素长度: " + len1 + ", 数组: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = removeDuplicates(nums2);
        System.out.print("不重复元素长度: " + len2 + ", 数组: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
    }
}
