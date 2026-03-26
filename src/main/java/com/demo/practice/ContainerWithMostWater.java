package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/30
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    // 时间复杂度：O(n)， 空间复杂度：O(1)
    public int maxArea(int[] height) {
        int left = 0; // 左指针
        int right = height.length - 1; // 右指针
        int maxArea = 0; // 最大面积

        while(left < right) {
            // 更新最大面积
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
//            int area = Math.min(height[left], height[right]) * (right - left);
//            maxArea = Math.max(maxArea, area);

            // 移动较短的指针，因为移动较长的指针不会增加容器的高度
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // 测试代码
    public static void main(String[] args) {
        ContainerWithMostWater demo = new ContainerWithMostWater();
        // 测试用例1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("测试数组1: [1, 8, 6, 2, 5, 4, 8, 3, 7]");
        System.out.println("最大盛水量: " + demo.maxArea(height1));
        System.out.println("正确答案: 49");
        System.out.println();

        // 测试用例2
        int[] height2 = {1, 1};
        System.out.println("测试数组2: [1, 1]");
        System.out.println("最大盛水量: " + demo.maxArea(height2));
        System.out.println("正确答案: 1");
        System.out.println();

        // 测试用例3
        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println("测试数组3: [4, 3, 2, 1, 4]");
        System.out.println("最大盛水量: " + demo.maxArea(height3));
        System.out.println("正确答案: 16");
        System.out.println();

        // 测试用例4
        int[] height4 = {1, 2, 1};
        System.out.println("测试数组4: [1, 2, 1]");
        System.out.println("最大盛水量: " + demo.maxArea(height4));
        System.out.println("正确答案: 2");
        System.out.println();
    }
}
