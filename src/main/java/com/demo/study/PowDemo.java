package com.demo.study;

/**
 * 50
 */
public class PowDemo {
    // 递归，有时间改造为非递归
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        // 偶数
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }

        // 奇数
        return x * myPow(x, n - 1);
    }
}
