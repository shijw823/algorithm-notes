package com.demo;

/**
 * 求平方根：二分查找
 * 69
 */
public class SqrtDemo {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;
        int result = -1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (mid == x / mid) {
                return mid;
            }  else if (mid > x / mid) {
                // 注意这里
                right = mid - 1;
            } else {
                // 注意这里
                left = mid + 1;
                // 注意这里
                result = mid;
            }
        }
        System.out.println("result=" + result);
        return result;
    }

    // 这个比较好
    public double mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        double left = 1;
        double right = x;
        double result = -1;

        while(left <= right) {
            //double mid = (left + right) / 2;
            double mid = left + (right - left) / 2;
            System.out.println("mid=" + mid);
            if (mid - x / mid < 0.00001) {
                return mid;
            }  else if (mid > x / mid) {
                // 注意这里
                right = mid;
            } else {
                // 注意这里
                left = mid;
                // 注意这里
                result = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SqrtDemo sqrtDemo = new SqrtDemo();
        System.out.println(sqrtDemo.mySqrt(8));
        System.out.println(sqrtDemo.mySqrt2(8));
    }
}
