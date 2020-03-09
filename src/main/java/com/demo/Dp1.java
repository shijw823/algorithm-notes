package com.demo;

/**
 * *********************
 * 动态规划1 dynamic programming
 * 从起点走到终点，共有几种走法
 */
public class Dp1 {
    public static void main(String[] args) {
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

    }

    public static int countPaths(boolean[][] grid, int row, int col) {
        int[][] opt = new int[row][col];
        for (int r = row - 1; r >= 0; r--) {
            for (int c = col - 1; c >= 0; c--) {
                if ((r == row - 1) || (c == col - 1)) {
                    opt[r][c] = 1;
                } else if (grid[r][c]) {
                    opt[r][c] = 0;
                } else if (!grid[r][c]) {
                    opt[r][c] = opt[r + 1][c] + opt[r][c + 1];
                }
            }
        }
        System.out.println(opt[6][7]);
        System.out.println(opt[7][6]);
        System.out.println(opt[0][1]);
        System.out.println(opt[1][0]);
        return opt[0][0];
    }


}
