package com.demo;

/**
 * **********************ok
 * 有序数组中绝对值最小的,要求时间复杂度小于O(n)
 * 二分查找
 * https://www.cnblogs.com/leezhxing/p/5468891.html
 */
public class ArrayAbs {

    public static void main(String[] args) {
        int[] array = new int[] {-5, -4, -4, -3, 1, 2};
        System.out.println(getMin(array));
        System.out.println(search(array, 0, array.length - 1));
    }

    private static int getMin(int[] array) {
        int len = array.length;
        // 都是整数
        if (array[0] >= 0) {
            return array[0];
        }
        // 都是负数
        else if (array[len - 1] < 0) {
            return array[len - 1];
        }
        // 正负都有
        else {
            return search(array, 0, len - 1);
        }
    }

    private static int search(int[] array, int left, int right) {
        while (left < right) {
            //int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;
            if (array[mid] > 0) {
                if (array[mid - 1] > 0) {
                    right = mid - 1;
                } else {
                    return array[mid] > Math.abs(array[mid - 1]) ? array[mid - 1] : array[mid];
                }
            } else if (array[mid] < 0) {
                if (array[mid + 1] < 0) {
                    left = mid + 1;
                } else {
                    return array[mid + 1] > Math.abs(array[mid]) ? array[mid] : array[mid + 1];
                }
            } else {
                return array[mid];
            }
        }
        return -999;
    }
}


