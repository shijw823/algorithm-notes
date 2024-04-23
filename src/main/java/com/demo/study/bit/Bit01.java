package com.demo.study.bit;

/**
 * 常用的位运算操作
 * X & 1 == 1 OR X & 1 == 0 判断奇数偶数
 * X = X & (X-1) => 清零最低位的1  23 11000 & 10111 -> 10000, 把1(1)000 这个1清掉
 * X & -X => 得到最低位的1  -X 是 X的取反+1
 * 0000 0011 & 1111 1101 ->  0000 0001
 * 0000 0010 & 1111 1110 ->  0000 0010
 * 0000 0101 & 1111 1011 ->  0000 0001
 * X & ~X => 0
 * <p>
 * 191
 * 有多少个二进制1
 */
public class Bit01 {

    // 这个好一些
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            // 消除掉二进制中最右边的一个1
            n = n & (n - 1);
        }
        System.out.println("result=" + count);
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        System.out.println("result=" + count);
        return count;
    }

    public static void main(String[] args) {
        Bit01 bit01 = new Bit01();
        bit01.hammingWeight(00000000000000000000000000001011);
        bit01.hammingWeight2(00000000000000000000000000001011);
        //bit01.hammingWeight(12);
    }
}
