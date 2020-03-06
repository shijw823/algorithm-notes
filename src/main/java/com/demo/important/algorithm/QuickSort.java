package com.demo.important.algorithm;

/**
 * 快排 时间复杂度 nlgn
 * https://www.jianshu.com/p/e4369c66d4a5
 * 1). 先从数列中取出一个数作为基准数。
 * 2). 分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 * 3). 再对左右区间重复第二步，直到各区间只有一个数。
 * @author shijianwei
 * @since 2017/12/25
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arrays = {2, 5, 1, 7, 8, 9, 10, 3, 4};
        sort(arrays, 0, arrays.length - 1);
        for (int temp : arrays) {
            System.out.println(temp);
        }
    }

    private static void sort(final int[] arrays, int low, int high) {
        if (arrays == null || arrays.length < 2) {
            return;
        }

        if (low < high) {
            int pivot = getPivot(arrays, low, high);
            // 左边排序
            sort(arrays, low, pivot - 1);
            // 右边排序
            sort(arrays, pivot + 1, high);
        }
    }

    private static int getPivot(final int[] arrays, int low, int high) {
        // 设置一个基准轴
        int pivotValue = arrays[low];
        while (low < high) {
            // 从右边高位向左移动
            while (low < high && arrays[high] >= pivotValue) {
                high--;
            }
            // 当右边高位的数值小于基准轴，则左边低位的数值设置为右边高位的值
            arrays[low] = arrays[high];

            // 从左边低位向右移动
            while (low < high && arrays[low] <= pivotValue) {
                low++;
            }
            // 当左边低位的数值大于基准轴，则右边高位的数值设置为左边低位的值
            arrays[high] = arrays[low];
        }
        arrays[low] = pivotValue;
        return low;
    }
}
