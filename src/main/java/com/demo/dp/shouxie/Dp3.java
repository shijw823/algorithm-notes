package com.demo.dp.shouxie;

/**
 * *********************ok
 * 动态规划 dynamic programming
 * 从起点走到终点，共有几种走法
 * 63
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
     *  0这个位置的走法 = 走向1的走法 + 走向2的走法
     * @param grid
     * @param row
     * @param col
     * @return
     */
    public static int countPaths(boolean[][] grid, int row, int col) {
        int opt[][] = new int[row][col];

        for (int i = row-1; i >=0; i--) {
            for (int j = col-1; j >=0 ; j--) {
                if (i == row-1 || j == col-1) {
                    opt[i][j] = 1;
                } else if (grid[i][j]) {
                    opt[i][j] = 0;
                } else if (!grid[i][j]) {
                    opt[i][j] = opt[i+1][j] + opt[i][j+1];
                }
            }
        }
        return opt[0][0];
    }

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
                } else if(!grid[i][j]) {
                    opt[i][j] = opt[i][j+1] + opt[i+1][j];
                }
            }
        }
        return opt[0][0];
    }

}
