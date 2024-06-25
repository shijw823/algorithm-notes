package com.demo.temp.shouxie;

/**
 * @author shijianwei
 */
public class Test {
    public static void main(String[] args) {
        Test demo = new Test();
        System.out.println(demo.sumNums(8));
        System.out.println(demo.sumNums2(8));
        System.out.println(demo.add(2, 5));
    }

    private int add(int a, int b) {
        while(a != 0) {
            int temp = a ^ b;
            a = (a & b) << 1;
            b = temp;
        }
        return b;
    }

    private int sumNums2(int n) {
        if (n == 1) {
            return n;
        }
        int sum = n;
        sum += sumNums2(n-1);
        return sum;
    }

    private int sumNums(int n) {
        int sum = n;
        boolean b = n > 0 && (sum += sumNums(n-1)) > 0;
        return sum;
    }
}
