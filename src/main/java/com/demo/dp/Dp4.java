package com.demo.dp;

/**
 * 丑数
 * https://leetcode.cn/problems/chou-shu-lcof/solutions/2201062/jian-zhi-offer-49-chou-shu-dong-tai-gui-14l4b/
 * https://leetcode.cn/problems/chou-shu-lcof/solutions/712103/chou-shu-by-leetcode-solution-0e5i/
 *
 * @author shijianwei
 * @since 2024/06/26
 */
public class Dp4 {
    public static void main(String[] args) {
        int result = new Dp4().nthUglyNumber(100);
        System.out.println(result);
    }
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        // 最小的丑数是1
        dp[1] = 1;
        /**
         * 如何得到其余的丑数呢？定义三个指针 p2,p3,p5，表示下一个丑数是当前指针指向的丑数乘以对应的质因数。
         * 初始时，三个指针的值都是 1。当 2≤i≤n 时，令 dp[i]=min(dp[p2]×2,dp[p3]×3,dp[p5]×5)，
         * 然后分别比较 dp[i] 和 dp[p2]×2,dp[p3]×3,dp[p5]×5 是否相等，如果相等则将对应的指针加 1
         *
         * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
         */

        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }

            if (dp[i] == num3) {
                p3++;
            }

            if (dp[i] == num5) {
                p5++;
            }
        }

        return dp[n];
    }
}
