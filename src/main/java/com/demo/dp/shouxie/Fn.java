package com.demo.dp.shouxie;

import java.util.Arrays;

/**
 * 动态规划：动态递推（自下而上）
 * 递推：自下而上
 * 递归：自上而下
 * 70，爬楼梯的走法，可以分析为是斐波那契 f(n) = f(n-1) + f(n-2)
 * f(n)：走到第n阶需要的总走法 = 走到第n-1阶需要的总走法（需要走1步）+走到第n-2阶需要的总走法（需要走2步）
 * <p>
 * 322 零钱兑换
 */
public class Fn {

    public static void main(String[] args) {
        System.out.println(fn(6));
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }

    // O(n)，还有一种比这更优的写法
    // 0, 1, 1, 2, 3, 5, 8, 13
    private static int fn(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    // 零钱兑换
    // 走楼梯的思路， 走到第11阶台阶，最少需要走几步
    // 1,2,5 可以走1步，2步，5步
    // 1+5+5=11
    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }


        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
