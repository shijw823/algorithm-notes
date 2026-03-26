package com.demo.practice;

/**
 * @author shijianwei
 * @date 2026/1/4
 * https://leetcode.cn/problems/arranging-coins/description/
 */
public class ArrangeCoinsTest {

    /**
     * 二分查找解法  时间复杂度：O(log n)，空间复杂度：O(1)
     * 步骤：
     *
     * 初始化 left=1, right=n
     *
     * 计算 mid 行的硬币总数
     *
     * 如果总数 ≤ n，说明可以完成至少 mid 行，更新结果并向右搜索
     *
     * 否则向左搜索
     *
     * 循环直到 left > right
     */
    public int arrangeCoinsBinarySearch(int n) {
        if (n <= 1) return n;

        long left = 1, right = n;
        int result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long total = mid * (mid + 1) / 2;

            if (total <= n) {
                result = (int) mid;  // 更新可能的结果
                left = mid + 1;      // 尝试更多的行
            } else {
                right = mid - 1;     // 减少行数
            }
        }

        return result;
    }
}
