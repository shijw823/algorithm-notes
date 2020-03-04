package com.demo.study.bit;

/**
 * 231
 * 338
 */
public class Bit02 {
    // 000010000
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // 0 - 5
    public int[] countBits(int num) {
        int[] result = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            // 有点斐波那契的意思
            result[i] = result[i & (i - 1)] + 1;
        }

        System.out.println("result=" + result);

        return result;
    }

    public static void main(String[] args) {
        Bit02 bit02 = new Bit02();
        int[] result = bit02.countBits(5);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
