package com.demo.dp;

/**
 * 动态规划
 * 递归 + 记忆化（缓存） = 递推
 *
 */
public class Fn2 {

    public static void main(String[] args) {
        int[] array = new int[7];

        System.out.println(f(6, array));
        System.out.println(fib(6));
    }

    // O(n)
    private static int f(int n, int[] array) {
        if (n == 0 || n == 1) {
            return n;
        } else if (array[n] == 0) {
            array[n] = f(n - 1, array) + f(n - 2, array);
        }
        return array[n];
    }

    // array[5] = array[4] + array[3];
    // array[4] = array[3] + array[2];
    // array[3] = array[2] + 1;
    // array[2] = 1;

    // O(2 ^ n)
    // 这个不好
    private static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }
}
