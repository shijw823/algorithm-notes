package com.demo.temp.shouxie;

/**
 * *********************ok
 * 有效的数独
 * 36,37
 */
public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !check(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(char[][] board, int x, int y) {
        char num = board[x][y];

        for (int i = 0; i < board.length; i++) {
            if (i != y && board[x][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (i != x && board[i][y] == num) {
                return false;
            }
        }
        int beginX = 3 * (x / 3);
        int beginY = 3 * (y / 3);

        for (int i = beginX; i < beginX + 3; i++) {
            for (int j = beginY; j < beginY + 3; j++) {
                if (i != x && j != y && board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
