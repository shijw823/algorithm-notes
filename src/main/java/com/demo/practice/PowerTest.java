package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/26
 */
public class PowerTest {
    // 方法1：快速幂算法（递归）
    public double myPow(double x, int n) {
        // 使用long避免n=-2147483648时取反溢出
        long N = n;

        // 处理负数次幂
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        // 递归终止条件
        if (n == 0) {
            return 1.0;
        }

        // 递归计算一半的幂
        double half = fastPow(x, n / 2);

        // 根据n的奇偶性返回结果
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PowerTest().myPow(2, -2));
    }
}
