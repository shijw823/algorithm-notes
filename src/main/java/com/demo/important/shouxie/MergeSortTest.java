package com.demo.important.shouxie;

/**
 * *********************
 * @author shijianwei
 * @since 2019/03/28
 */
public class MergeSortTest {

    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] tempArray = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }


        while (i <= mid) {
            tempArray[k++] = array[i++];
        }

        while (j <= high) {
            tempArray[k++] = array[j++];
        }

        for (int m = 0; m < tempArray.length; m++) {
            array[low + m] = tempArray[m];
        }
    }


    public static void main(String[] args) {
        int[] test = {9, 2, 6, 3, 5, 7, 10, 11, 12};
        mergeSort(test, 0, test.length - 1);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }

    }
}
