package com.demo.temp.shouxie;

/**
 * 求平方根：二分查找
 * 69
 */
public class SqrtDemo {
    public int mySqrt(int x) {
        int result = 0;
        int left = 1;
        int right = x;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else if (mid * mid < x) {
                left = mid + 1;
                result = mid;
            } else {
                return mid;
            }
        }
        return result;
    }

    // 这个比较好
    public double mySqrt2(int x) {
        double result = 0;
        double left = 1;
        double right = x;

        while(left < right) {
            double mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid;
            } else if (mid * mid - x  < 0.00001) {
                return mid;
            } else {
                left = mid;
                result = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SqrtDemo sqrtDemo = new SqrtDemo();
        System.out.println(sqrtDemo.mySqrt(8));
        System.out.println(sqrtDemo.mySqrt2(9));
    }
}
