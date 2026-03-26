package com.demo.practice;

import java.util.Arrays;

/**
 * @author shijianwei
 * @date 2025/12/30
 */
public class PlusOneTest {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // 如果所有位都是9，需要增加数组长度
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        PlusOneTest solution = new PlusOneTest();

        // 测试用例1：普通情况
        int[] digits1 = {1, 2, 3};
        System.out.println(Arrays.toString(solution.plusOne(digits1)));  // [1, 2, 4]

        // 测试用例2：有进位
        int[] digits2 = {1, 2, 9};
        System.out.println(Arrays.toString(solution.plusOne(digits2)));  // [1, 3, 0]

        // 测试用例3：多个连续进位
        int[] digits3 = {1, 9, 9};
        System.out.println(Arrays.toString(solution.plusOne(digits3)));  // [2, 0, 0]

        // 测试用例4：全为9，需要增加数组长度
        int[] digits4 = {9, 9, 9};
        System.out.println(Arrays.toString(solution.plusOne(digits4)));  // [1, 0, 0, 0]

        // 测试用例5：单个数
        int[] digits5 = {0};
        System.out.println(Arrays.toString(solution.plusOne(digits5)));  // [1]
    }
}
