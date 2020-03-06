package com.demo.important.algorithm;

/**
 * 二分查找 时间复杂度 lgn
 *
 * @author shijianwei
 * @create 2017-10-05
 */
public class ErfenSearchDemo {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 6, 7, 9, 23, 34, 78};
        int searchNum = 4;
        int startIndex = 0;
        int endIndex = array.length - 1;

        while (endIndex > startIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if (array[midIndex] > searchNum) {
                endIndex = midIndex - 1;
            }
            else if (array[midIndex] < searchNum) {
                startIndex = midIndex + 1;
            }
            else {
                System.out.println("找到了,索引是：" + midIndex);
                return;
            }
        }
        System.out.println("不存在");
    }
}
