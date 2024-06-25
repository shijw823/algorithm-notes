package com.demo.mianshishu;

/**
 * ############
 * 旋转数组的最小值
 * 153
 */
public class ArrayMin {

    public static void main(String[] args) {
         int[] array = new int[]{3, 4, 5, 1, 2};
        //int[] array = new int[]{4, 5, 1, 2, 3};
        System.out.println(new ArrayMin().findMin(array));
    }

    /**
     * 如果中值 < 右值，则最小值在左半边，可以收缩右边界。
     * 如果中值 > 右值，则最小值在右半边，可以收缩左边界。
     * 通过比较中值与右值，可以确定最小值的位置范围，从而决定边界收缩的方向
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println("left:" + left + ",right:" + right);
        return nums[left];
    }
}
