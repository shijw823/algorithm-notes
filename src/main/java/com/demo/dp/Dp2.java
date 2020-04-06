package com.demo.dp;

/**
 * 300
 * 最长上升子序列
 *
 * @author shijianwei
 * @since 2020/04/06
 */
public class Dp2 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLenJ = 0;
        for (int j = 0; j < nums.length; j++) {
            int maxLenI = 0;
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    maxLenI = Math.max(maxLenI, dp[i]);
                }
            }
            dp[j] = maxLenI + 1;
            maxLenJ = Math.max(maxLenJ, dp[j]);
        }
        return maxLenJ;
    }
}
