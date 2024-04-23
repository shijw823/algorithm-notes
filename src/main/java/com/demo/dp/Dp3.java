package com.demo.dp;

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
                    // 最后一行或者最后一列, 只有向右的或向下的，所以为1
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
