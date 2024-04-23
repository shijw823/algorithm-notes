package com.demo.temp;

/**
 * **********************ok
 * 不用加减乘除做加法
 * 2235
 * AddTest
 */
public class Q65 {
    public static void main(String[] args) {
        Q65 demo = new Q65();
        System.out.println(demo.add(2, 5));
        System.out.println(demo.add(5, 10));
        swap(2, 3);
        System.out.println("--------------");
        swap2(2, 3);
    }

    // 13 + 8
    // 1101 + 1000
    public int add(int a, int b) {
        while (a != 0) {
            // 10000 00101
            int temp = a ^ b; //不带进位和
            a = (a & b) << 1; //进位
            b = temp;
        }
        return b;
    }

    public static void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }

    public static void swap2(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
