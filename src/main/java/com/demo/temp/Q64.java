package com.demo.temp;

/**
 * 求1+2+…+n
 */
public class Q64 {

    public static void main(String[] args) {
        Q64 demo = new Q64();
        System.out.println(demo.sumNums(10));
    }

    public int sumNums(int n) {
        int sum = n;
        // 利用&&短路原则，第一个n>0不满足时，就不执行后面的遍历了，相当于递归终止条件
        boolean b = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
