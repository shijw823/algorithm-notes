package com.demo.important.algorithm.shouxie;

/**
 * @author shijianwei
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arrays = {2, 5, 1, 7, 8, 9, 10, 3, 4};
        sort(arrays, 0, arrays.length-1);
        for (int temp : arrays) {
            System.out.println(temp);
        }
    }

    private static void sort(int[] arrays, int low, int high) {
        if (low < high) {
            int pivot = getPivot(arrays, low, high);
            sort(arrays, low, pivot - 1);
            sort(arrays, pivot + 1, high);
        }

    }

    private static int getPivot(int[] arrays, int low, int high) {
        int pivotValue = arrays[low];
        while(low < high) {
            while (low < high && arrays[high] > pivotValue) {
                high--;
            }
            arrays[low] = arrays[high];
            while (low < high && arrays[low] < pivotValue) {
                low++;
            }
            arrays[high] = arrays[low];
        }
        arrays[low] = pivotValue;
        return low;
    }
}
