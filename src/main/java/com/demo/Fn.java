package com.demo;

/**
 * 动态规划，动态递推（自下而上）
 * 递推：自下而上
 * 递归：自上而下
 * 70，爬楼梯的走法，可以分析为是斐波那契 f(n) = f(n-1) + f(n-2)
 */
public class Fn {

    public static void main(String[] args) {
        System.out.println(fn(6));
    }

    private static int fn(int n) {
        int[] f = new int[n+1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}
