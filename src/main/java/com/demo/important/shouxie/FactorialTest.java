package com.demo.important.shouxie;

/**
 * 阶乘
 *
 * @author shijianwei
 * @since 2020/04/05
 */
public class FactorialTest {

    public static void main(String[] args) {
        FactorialTest factorialTest = new FactorialTest();
        System.out.println(factorialTest.fn(5));
        System.out.println(factorialTest.fn2(2, 10));
    }

    // 非递归实现
    private int fn2(int x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        int result = 1;
        while (n != 0) {
            // 奇数
            if ((n & 1) != 0) {
                result *= x;
            }
            x *= x;
            n >>= 1;
        }
        return result;
    }

    // 递归实现
    private int fn(int num) {
        if (num == 1) {
            return 1;
        }

        int[] array = new int[num + 1];

        for (int i = 2; i <= num; i++) {
            array[i] = fn(i - 1) * i;
        }
        return array[num];
    }
}
