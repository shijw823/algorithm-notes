package com.demo.temp;

/**
 * **********************ok
 * 求1+2+…+n
 */
public class Q64 {

    public static void main(String[] args) {
        Q64 demo = new Q64();
        System.out.println(demo.sumNums(10));
        System.out.println(demo.sumNums2(10));
        System.out.println(demo.sumNums3(10));
    }

    // 可以翻译成sumNums2
    public int sumNums(int n) {
        int sum = n;
        // 利用&&短路原则，第一个n>0不满足时，就不执行后面的遍历了，相当于递归终止条件
        boolean b = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }

    public int sumNums2(int n) {
        int sum = n;
        if (n == 1) {
            return sum;
        }
        sum += sumNums2(n - 1);
        return sum;
    }

    public int sumNums3(int n) {
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i-1] + i;
        }

        return array[n];
    }

}
