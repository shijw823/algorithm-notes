package com.demo.mianshishu;

/**
 * 奇数排在偶数的前面
 */
public class ArrayDemo {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 8, 6, 7};
        reOrderOddEven(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void reOrderOddEven(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            while (left < right && array[left] % 2 == 1) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

    }

}


