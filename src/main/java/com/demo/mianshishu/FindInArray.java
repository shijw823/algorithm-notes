package com.demo.mianshishu;

/**
 * 在二维数组中查找某一个数
 *
 */
public class FindInArray {


    public static void main(String[] args) {
        int[][] array = new int[][] {
                // 从左到右递增，从上到下递增
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };

        FindInArray findInArray = new FindInArray();
        System.out.println(findInArray.find(array, 11));

    }

    private boolean find(int[][] array, int num) {
        // 从第一行最右边列开始
        int row = 0;
        int col = array[0].length-1;
        while(row < array.length && col >= 0) {
            if (num == array[row][col]) {
                System.out.println(row + ":" + col);
                return true;
            }
            // 排除掉col列数据
            else if (num < array[row][col]) {
                col--;
            }
            // 排除掉row行数据
            else {
                row++;
            }
        }
        return false;
    }
}
