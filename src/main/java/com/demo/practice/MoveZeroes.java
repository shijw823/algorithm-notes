package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/30
 * https://leetcode.cn/problems/move-zeroes/
 */
public class MoveZeroes {
    // 时间复杂度：O(n)， 空间复杂度：O(1)
    public void moveZeroes(int[] nums) {
        int index = 0;
        // 将所有非零元素移到前面
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        // 剩余位置补0
        while(index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
