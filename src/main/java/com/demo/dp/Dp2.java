package com.demo.dp;

/**
 * 300
 * 最长上升子序列的长度
 *
 * DP[i]:从头到第i个元素最长上升子序列的长度
 * max(DP[0],DP[1],...DP[n-1])
 * O(n*n)
 * shipin
 *
 * @author shijianwei
 * @since 2020/04/06
 */
public class Dp2 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int result = 1;
        // 默认是1，比如是倒序的数组
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            // 从j到i
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    //public int lengthOfLIS(int[] nums) {
    //    int[] dp = new int[nums.length];
    //    int maxLenJ = 0;
    //    for (int j = 0; j < nums.length; j++) {
    //        int maxLenI = 0;
    //        for (int i = 0; i < j; i++) {
    //            if (nums[i] < nums[j]) {
    //                maxLenI = Math.max(maxLenI, dp[i]);
    //            }
    //        }
    //        dp[j] = maxLenI + 1;
    //        maxLenJ = Math.max(maxLenJ, dp[j]);
    //    }
    //    return maxLenJ;
    //}

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 20};
        // 2，3，7，18，20
        System.out.println(new Dp2().lengthOfLIS(nums));
    }
}
