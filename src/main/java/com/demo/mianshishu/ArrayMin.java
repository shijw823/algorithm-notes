package com.demo.mianshishu;

/**
 * 旋转数组的最小值
 * 有问题
 */
public class ArrayMin {

    public static void main(String[] args) {
        // int[] array = new int[]{3, 4, 5, 1, 2};
        int[] array = new int[]{4, 5, 1, 2, 3};
        System.out.println(min(array, 0, array.length - 1));
    }

    private static int min(int[] array, int low, int high) {
        while (array[low] >= array[high]) {
            if (high - low == 1) {
                return array[high];
            }
            int middle = (low + high) / 2;
            if (array[middle] > array[low]) {
                low = middle;
            } else if (array[middle] < array[high]) {
                high = middle;
            }
        }
        return -1;
    }
}
