package com.demo;

/**
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
                right = mid - 1;
            } else {
                left = mid + 1;
                result = mid;
            }
        }
        System.out.println(result);
        return result;
    }

    public double mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        double left = 1;
        double right = x;
        double result = -1;

        while(left <= right) {
            double mid = (left + right) / 2;
            System.out.println("mid=" + mid);
            if (mid - x / mid > 0 && mid - x / mid < 0.00001) {
                return mid;
            }  else if (mid > x / mid) {
                right = mid;
            } else {
                left = mid;
                result = mid;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        SqrtDemo sqrtDemo = new SqrtDemo();
        System.out.println(sqrtDemo.mySqrt2(2));
    }
}
