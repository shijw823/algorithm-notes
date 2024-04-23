package com.demo.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 120  三角形的最小路径和
 * 二维数组
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * 返回 11=2+3+5+1
 *
 * O(m * n)
 *
 * @author shijianwei
 * @since 2020/04/06
 */
public class Dp1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(triangle.size() - 1).size() == 0) {
            return 0;
        }
        // 倒数第二行
        for (int i = triangle.size()-2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 倒数第一行
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                // 倒数第二行
                min += triangle.get(i).get(j);
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }
    public int minimumTotal2(List<List<Integer>> triangle) {
        // 最后一行4列
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        // 最后一行第四行的数据
        for (int i = 0; i < triangle.get(triangle.size()-1).size(); i++) {
            dp[i] = triangle.get(triangle.size()-1).get(i);
            System.out.println(dp[i]);
        }
        System.out.println("-------------------");

        // 行的索引，自下向上
        // 从第三行开始
        for (int i = triangle.size()-2; i >= 0; i--) {
            // 2 行
            // 1 行
            // 0 行
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 0,1,2；
                // 0,1；
                // 0
                // 下一行的左右两个数的最小值 + 当前行数据
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
                System.out.println(i + "&" + j + ":" + dp[j]);

                /**
                 * 2&0:7
                 * 2&1:6
                 * 2&2:10
                 * 1&0:9
                 * 1&1:10
                 * 0&0:11
                 */
            }
            System.out.println("----------------");
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> subList1 = new ArrayList<>();
        subList1.add(2);
        list.add(subList1);

        List<Integer> subList2 = new ArrayList<>();
        subList2.add(3);
        subList2.add(4);
        list.add(subList2);

        List<Integer> subList3 = new ArrayList<>();
        subList3.add(6);
        subList3.add(5);
        subList3.add(7);
        list.add(subList3);

        List<Integer> subList4 = new ArrayList<>();
        subList4.add(4);
        subList4.add(1);
        subList4.add(8);
        subList4.add(3);
        list.add(subList4);

        System.out.println(list.size());
        System.out.println("---------------------");

        System.out.println(new Dp1().minimumTotal(list));
    }
}
