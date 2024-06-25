package com.demo.study;

/**
 * 50
 * O(logn)
 * 分治处理：一分为2，分偶数和奇数情况
 * 偶数：(x ^ n/2) * (x ^ n/2)
 * 奇数：(x ^ n/2) * (x ^ n/2) * x
 */
public class PowDemo {
    public static void main(String[] args) {
        PowDemo powDemo = new PowDemo();
        System.out.println(powDemo.myPow2(2.0, -3));
        System.out.println(powDemo.pow2(2, -3));
    }

    public int pow(int x, int n) {
        if (n < 0) {
            return 1 / pow(x, -n);
        }
        if (n == 0) {
            return 1;
        }
        int result = pow(x, n/2);
        // (n & 1) == 1 代表奇数
        return (n & 1) == 1 ? x * result * result : result * result;
    }

    // 这个最好
    public double pow2(int x, int n) {
        // x == 0 考虑
        if (n < 0) {
            return 1.0 / pow2(x, -n);
        }
        if (n == 0) {
            return 1;
        }
        double result = pow2(x, n/2);
        // (n & 1) == 1 代表奇数
        return (n & 1) == 1 ? x * result * result : result * result;
    }

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

    // 非递归
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double result = 1.0;

        // 处理n为负数的情况
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        while (n > 0) {
            // 如果n是奇数
            if ((n & 1) == 1) {
                result *= x;
            }
            n >>= 1;
            x *= x;
        }

        return result;
    }
}
