package com.demo;

import java.util.Arrays;

/**
 * 数组中有2n个元素，n个奇数，n个偶数，使得奇数下标保存奇数，偶数下标保存偶数
 */
public class ArrayDemo {


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 2, 4, 6, 7, 15, 26, 8};
        //int[] resultArray = new int[array.length];
        //
        //// 偶数
        //int j = 0;
        //// 奇数
        //int k = 1;
        //for (int i = 0; i < array.length; i++) {
        //    if (array[i] % 2 == 0) {
        //        resultArray[j] = array[i];
        //        j += 2;
        //    } else {
        //        resultArray[k] = array[i];
        //        k += 2;
        //    }
        //}
        //System.out.println(Arrays.toString(resultArray));

        int j = 0;
        int k = 1;

        // 1, 3, 5, 2, 4, 6, 7, 15, 26, 8
        while(j < array.length && k < array.length) {
            while(j < array.length && array[j] % 2 == 0) {
                j += 2;
            }
            while(k < array.length && array[k] % 2 == 1) {
                k += 2;
            }
            if (j < array.length) {
                int temp = array[j];
                array[j] = array[k];
                array[k] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
