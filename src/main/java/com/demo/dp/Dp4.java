package com.demo.dp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 丑数
 * https://leetcode.cn/problems/chou-shu-lcof/solutions/2201062/jian-zhi-offer-49-chou-shu-dong-tai-gui-14l4b/
 * https://leetcode.cn/problems/chou-shu-lcof/solutions/712103/chou-shu-by-leetcode-solution-0e5i/
 * @@@@@
 *
 * @author shijianwei
 * @since 2024/06/26
 */
public class Dp4 {
    public static void main(String[] args) {
        int result = new Dp4().nthUglyNumber(100);
        System.out.println(result);

        result = new Dp4().getNthUglyNumber(100);
        System.out.println(result);

        result = new Dp4().getNthUglyNumber2(100);
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

    // 时间复杂度：O(n)，空间复杂度：O(n)

    /**
     * 例如，丑数序列：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
     *
     * 下一个丑数是 min(2×2, 3×2, 5×1) = min(4, 6, 5) = 4
     *
     * 选中4后，乘以2的指针移动到下一个位置
     *
     * @param n
     * @return
     */
    public int getNthUglyNumber(int n) {
        if (n <= 0) return 0;

        int[] ugly = new int[n];
        ugly[0] = 1;

        // 三个指针
        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            // 计算三个候选值
            int next2 = ugly[i2] * 2;
            int next3 = ugly[i3] * 3;
            int next5 = ugly[i5] * 5;

            // 取最小值作为下一个丑数
            ugly[i] = Math.min(next2, Math.min(next3, next5));

            // 移动指针（可能有多个指针同时移动）
            if (ugly[i] == next2) i2++;
            if (ugly[i] == next3) i3++;
            if (ugly[i] == next5) i5++;
        }

        return ugly[n - 1];
    }

    /**
     * https://leetcode.cn/problems/chou-shu-lcof/solutions/712103/chou-shu-by-leetcode-solution-0e5i/
     *
     * 使用优先队列（最小堆）的解法
     * 时间复杂度：O(n log n)
     *
     * 思路：
     * 1. 使用最小堆存储丑数
     * 2. 每次弹出最小的丑数
     * 3. 将其乘以2、3、5后加入堆中
     * 4. 使用集合去重
     */
    public int getNthUglyNumber2(int n) {
        if (n <= 0) return 0;

        // 最小堆，用于获取当前最小的丑数
        PriorityQueue<Long> heap = new PriorityQueue<>();
        // 用于去重
        Set<Long> uglyNumberSet = new HashSet<>();

        // 初始丑数1
        heap.offer(1L);
        uglyNumberSet.add(1L);

        long currentUgly = 1;
        int[] primes = {2, 3, 5};

        for (int i = 0; i < n; i++) {
            // 弹出当前最小的丑数
            currentUgly = heap.poll();

            // 生成新的丑数：当前丑数 * 2, *3, *5
            for (int prime : primes) {
                long newUgly = currentUgly * prime;

                // 如果还没有生成过这个丑数，就加入堆中
                if (uglyNumberSet.add(newUgly)) {
                    heap.offer(newUgly);
                }
            }
        }

        System.out.println(heap);

        return (int) currentUgly;
    }
}
