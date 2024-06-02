package com.demo.dp.shouxie;

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
    // DP[i][j] = min(DP[i+1][j], DP[i+1][j+1]) + triangle[i][j]
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        for (int i = 0; i < triangle.get(triangle.size()-1).size(); i++) {
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i = triangle.size()-2; i >=0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
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
