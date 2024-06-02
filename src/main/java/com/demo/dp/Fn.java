package com.demo.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 动态规划：动态递推（自下而上）
 * 递推：自下而上
 * 递归：自上而下
 * 70，爬楼梯的走法，可以分析为是斐波那契 f(n) = f(n-1) + f(n-2)
 * f(n)：走到第n阶需要的总走法 = 走到第n-1阶需要的总走法（需要走1步）+走到第n-2阶需要的总走法（需要走2步）
 * <p>
 * 322 零钱兑换 shipin
 */
public class Fn {

    public static void main(String[] args) {
        System.out.println(fn(6));
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 3));
    }

    // O(n)，还有一种比这更优的写法
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
        System.out.println(Arrays.toString(dp));
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    // dp[i]有两种实现的方式，
                    // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 dp[i-coins[j]] + 1
                    // 另一种就是不包含，要兑换的硬币数是memo[i]
                    // 到第i台阶，最少走的步数，在i-coins[j]台阶走的步数，再走1步（走coins[j]台阶数） 就到达i
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}
