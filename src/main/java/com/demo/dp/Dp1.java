package com.demo.dp;

import java.util.List;

/**
 * 120
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * 返回 11=2+3+5+1
 *
 * @author shijianwei
 * @since 2020/04/06
 */
public class Dp1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        // 最后一行的数据
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }

        for (int i = triangle.size()-2; i >= 0; i--) {
            // 2
            // 1
            // 0
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 0,1,2；
                // 0,1；
                // 0
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
