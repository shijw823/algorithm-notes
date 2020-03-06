package com.demo.study.bit;

/**
 * 191
 * 有多少个二进制1
 */
public class Bit01 {

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count ++;
            // 消除掉二进制中最右边的一个1
            n = n & (n - 1);
        }
        System.out.println("result=" + count);
        return count;
    }

    // public int hammingWeight(int n) {
    //     int count = 0;
    //     while(n != 0) {
    //         if (n % 2 == 1) {
    //             count++;
    //         }
    //         n =  n >> 1;
    //     }
    //     System.out.println("result=" + count);
    //     return count;
    // }

    public static void main(String[] args) {
        Bit01 bit01 = new Bit01();
        // bit01.hammingWeight(00000000000000000000000000001011);
        bit01.hammingWeight(12);
    }
}
