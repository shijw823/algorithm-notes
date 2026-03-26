package com.demo.mianshishu;

/**
 * ##############
 * 奇数排在偶数的前面
 */
public class ArrayDemo {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 8, 6, 7};
        reOrderOddEven(array);
        // 1 7 3 5 4 8 6 2
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        reorderOddEvenPartition(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // 单指针法（类似快速排序的partition）， 这个比较好记忆
    // 时间复杂度：O(n) 空间复杂度：O(1)  原地修改，保持奇数顺序但会打乱偶数顺序
    public static void reorderOddEvenPartition(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int partitionIndex = 0;  // 分割点，左边都是奇数

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                // 如果当前是奇数，交换到前面
                int temp = array[i];
                array[i] = array[partitionIndex];
                array[partitionIndex] = temp;
                partitionIndex++;
            }
        }
    }

    // 双指针法（原地交换）
    // 时间复杂度：O(n) 空间复杂度：O(1)  原地修改，不保持原顺序
    public static void reOrderOddEven(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // array[left] % 2 == 1 奇数在左边
            while (left < right && (array[left] & 1) == 1) {
                left++;
            }
            // array[right] % 2 == 0  偶数在右边
            while (left < right && (array[right] & 1) == 0) {
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


