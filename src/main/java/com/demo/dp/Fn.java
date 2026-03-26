package com.demo.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 动态规划：动态递推（自下而上）
 * 递推：自下而上
 * 递归：自上而下
 * 70，爬楼梯的走法，可以分析为是斐波那契 f(n) = f(n-1) + f(n-2)
 * https://leetcode.cn/problems/climbing-stairs/description/
 * f(n)：走到第n阶需要的总走法 = 走到第n-1阶需要的总走法（需要走1步）+走到第n-2阶需要的总走法（需要走2步）
 * <p>
 * 322 零钱兑换 shipin
 */
public class Fn {

    public static void main(String[] args) {
        System.out.println(fn(8));
        System.out.println(climbStairs(8));
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }

    // O(n)，还有一种比这更优的写法， 不对
    // 0, 1, 1, 2, 3, 5, 8, 13
    private static int fn(int n) {
        int[] f = new int[n + 1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    // 这个是正确的
    public static int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        // dp[i]表示爬到第i阶楼梯的方法数
        int[] dp = new int[n + 1];
        dp[1] = 1; // 爬到第1阶：1种方法（1步）
        dp[2] = 2; // 爬到第2阶：2种方法（1+1 或 2步）

        for (int i = 3; i <= n; i++) {
            // 到达第i阶可以从第i-1阶走1步，或从第i-2阶走2步
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // 零钱兑换 shipin？
    // 走楼梯的思路， 走到第11阶台阶，最少需要走几步
    // 1,2,5 可以走1步，2步，5步
    // 1+5+5=11
    private static int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        // dp[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] dp = new int[amount + 1];
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(dp, amount + 1);
        // [12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
        dp[0] = 0; // 金额为0时不需要硬币
        System.out.println(Arrays.toString(dp));
        // 遍历所有金额
        for (int i = 1; i <= amount; i++) {
            // 尝试每一种硬币：1，2，5
            for (int coin : coins) {
                // 如果当前硬币面值小于等于当前金额
                if (i >= coin) {
                    // dp[i]有两种实现的方式，
                    // 一种是包含当前的coin,那么剩余钱就是 i-coin,这种操作要兑换的硬币数是 dp[i-coin] + 1
                    // 另一种就是不包含，要兑换的硬币数是memo[i]
                    // 到第i台阶，最少走的步数，在i-coin台阶走的步数，再走1步（走coin台阶数） 就到达i
                    // 状态转移方程：dp[i] = min(dp[i], dp[i-coin] + 1)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果dp[amount]仍然为初始值，说明无法凑齐
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}
