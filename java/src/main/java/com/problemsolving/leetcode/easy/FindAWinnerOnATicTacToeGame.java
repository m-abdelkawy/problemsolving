package com.problemsolving.leetcode.easy;

/**
 * 1275. Find Winner on a Tic Tac Toe Game
 * Link: https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 13.05.2023
 */
public class FindAWinnerOnATicTacToeGame {
    public String tictactoe1(int[][] moves) {
        // simulate the grid
        char[][] grid = new char[3][3];
        boolean plawSwitch = true;
        int n = moves.length;
        for (int i = 0; i < n; i++) {
            if (plawSwitch) {
                grid[moves[i][0]][moves[i][1]] = 'X';
            } else {
                grid[moves[i][0]][moves[i][1]] = 'Y';
            }
            plawSwitch = !plawSwitch;
        }

        // check hz and vl
        for (int i = 0; i < 3; i++) {
            // hz
            if (grid[i][0] != '\u0000' && (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2])) {
                if (grid[i][0] == 'X') {
                    return "A";
                } else if (grid[i][0] == 'Y') {
                    return "B";
                }
            }

            // vl
            if (grid[0][i] != '\u0000' && (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i])) {
                if (grid[0][i] == 'X') {
                    return "A";
                } else if (grid[0][i] == 'Y') {
                    return "B";
                }
            }
        }

        // check diagonals
        if (grid[0][0] != '\u0000' && (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])) {
            if (grid[0][0] == 'X') {
                return "A";
            } else if (grid[0][0] == 'Y') {
                return "B";
            }
        }
        if (grid[0][2] != '\u0000' && (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])) {
            if (grid[0][2] == 'X') {
                return "A";
            } else if (grid[0][2] == 'Y') {
                return "B";
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    public String tictactoe2(int[][] moves) {
// simulate the grid
        char[][] grid = new char[3][3];
        boolean plawSwitch = true;
        int n = moves.length;
        for (int i = 0; i < n; i++) {
            if (plawSwitch) {
                grid[moves[i][0]][moves[i][1]] = 'X';
            } else {
                grid[moves[i][0]][moves[i][1]] = 'Y';
            }
            plawSwitch = !plawSwitch;
        }

        // check hz and vl
        for (int i = 0; i < 3; i++) {
            // hz
            if ((grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2])) {
                if (grid[i][0] == 'X') {
                    return "A";
                } else if (grid[i][0] == 'Y') {
                    return "B";
                }
            }

            // vl
            if ((grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i])) {
                if (grid[0][i] == 'X') {
                    return "A";
                } else if (grid[0][i] == 'Y') {
                    return "B";
                }
            }
        }

        // check diagonals
        if ((grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])) {
            if (grid[0][0] == 'X') {
                return "A";
            } else if (grid[0][0] == 'Y') {
                return "B";
            }
        }
        if ((grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])) {
            if (grid[0][2] == 'X') {
                return "A";
            } else if (grid[0][2] == 'Y') {
                return "B";
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
