package com.demo.dp;

/**
 * *********************ok
 * 动态规划 dynamic programming
 * 从起点走到终点，共有几种走法
 * 63 https://leetcode.cn/problems/unique-paths-ii/
 */
public class Dp3 {
    public static void main(String[] args) {
        // 障碍物为true， 空位置为false
        // 现在的写法的前提：必须保障有路可走
        boolean[][] data = new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, true, false, false, false, true, false},
                {false, false, false, false, true, false, false, false},
                {true, false, true, false, false, true, false, false},
                {false, false, true, false, false, false, false, false},
                {false, false, false, true, true, false, true, false},
                {false, true, false, false, false, true, false, false},
                {false, false, false, false, false, false, false, false}
        };

        System.out.println(countPaths(data, 8, 8));
        System.out.println(uniquePathsWithObstacles(data));

    }

    /**
     *  0 1
     *  2 3
     *  0 == 1+2  状态转移方程
     * @param grid
     * @param row
     * @param col
     * @return
     */
    public static int countPaths(boolean[][] grid, int row, int col) {
        int[][] opt = new int[row][col];
        for (int r = row - 1; r >= 0; r--) {
            for (int c = col - 1; c >= 0; c--) {
                if ((r == row - 1) || (c == col - 1)) {
                    // 最后一行或者最后一列, 只有向右的或向下的一种走法，所以为1
                    // 0 == 1+2  状态转移方程
                    opt[r][c] = 1;
                } else if (grid[r][c]) {
                    opt[r][c] = 0;
                } else if (!grid[r][c]) {
                    // 状态转移方程
                    opt[r][c] = opt[r + 1][c] + opt[r][c + 1];
                }
            }
        }
        System.out.println("6,7 " + opt[6][7]);
        System.out.println("7,6 " + opt[7][6]);
        System.out.println("0,1 " + opt[0][1]);
        System.out.println("1,0 " + opt[1][0]);
        System.out.println("7,7 " + opt[7][7]);
        System.out.println("---------");
        return opt[0][0];
    }

    // 从右下角走到左上角
    public static int uniquePathsWithObstacles(boolean[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] opt = new int[row][col];
        for(int i=row-1;i>=0;i--) {
            for(int j=col-1;j>=0;j--) {
                if((i == row-1) || (j == col-1)) {
                    opt[i][j] = 1;
                } else if (grid[i][j]) {
                    opt[i][j] = 0;
                } else {
                    opt[i][j] = opt[i][j+1] + opt[i+1][j];
                }
            }
        }
        return opt[0][0];
    }

    // 从左上角走到右下角
    public int uniquePaths(int m, int n) {
        // 创建dp数组，dp[i][j]表示从起点到(i,j)的路径数
        int[][] dp = new int[m][n];

        // 初始化第一行和第一列
        // 第一行：从起点只能一直向右走，每条路径都是1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 第一列：从起点只能一直向下走，每条路径都是1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // 填充dp数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 到达(i,j)的路径数 = 从上边来的路径数 + 从左边来的路径数
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

}
