package com.demo.temp.shouxie;

/**
 * @author shijianwei
 */
public class Test2 {
    public static void main(String[] args) {
        int[] array = new int[] {-5, -4, -4, -3, 1, 2};
        System.out.println(getMin(array));
    }

    private static int getMin(int[] array) {
        int len = array.length;
        if (array[0] >= 0) {
            return array[0];
        } else if (array[len - 1] < 0) {
            return array[len-1];
        }
        return search(array, 0, len-1);
    }

    private static int search(int[] array, int start, int end) {
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > 0) {
                if (array[mid-1] > 0) {
                    end = mid - 1;
                } else {
                    return array[mid] > Math.abs(array[mid-1]) ?  array[mid-1] : array[mid];
                }
            } else if(array[mid] < 0) {
                if (array[mid+1] < 0) {
                    start = mid + 1;
                } else {
                    return array[mid+1] > Math.abs(array[mid]) ?  array[mid] : array[mid+1];
                }
            } else {
                return array[mid];
            }
        }
        return 0;
    }
}
