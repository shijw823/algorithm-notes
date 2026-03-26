package com.demo.dp;

/**
 * 动态规划
 * 递归 + 记忆化（缓存） = 递推
 *
 */
public class Fn2 {

    public static void main(String[] args) {
        int[] array = new int[9];

        System.out.println(f(8, array));
        System.out.println(f2(8));
        System.out.println(fib(8));
    }

    private static int f2(int n) {
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[n];
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
