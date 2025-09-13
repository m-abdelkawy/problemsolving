package com.problemsolving.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * Link: https://leetcode.com/problems/valid-sudoku/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 27.06.2022
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] cols = new HashSet[9];
        Set<Integer>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int k = 3 * (i / 3) + (j / 3);

                int num = board[i][j] - '0';

                if (rows[i].contains(num)
                        || cols[j].contains(num)
                        || squares[k].contains(num)) {
                    return false;
                }

                rows[i].add(num);
                cols[j].add(num);
                squares[k].add(num);
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                int k = 3 * (i / 3) + (j / 3);
                if (value != '.') {
                    if (!seen.add(value + " row " + i)
                            || !seen.add(value + " column " + j)
                            || !seen.add(value + " block " + k)) {
                        return false;
                    }

                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(String[][] board) {
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] cols = new HashSet[9];
        Set<Integer>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == ".")
                    continue;

                int k = 3 * (i / 3) + (j / 3);

                int num = Integer.parseInt(board[i][j]);

                if (rows[i].contains(num)
                        || cols[j].contains(num)
                        || squares[k].contains(num)) {
                    return false;
                }

                rows[i].add(num);
                cols[j].add(num);
                squares[k].add(num);
            }
        }
        return true;
    }

    public boolean isValidSudoku3(String[][] board) {
        int row = board.length;
        int col = board[0].length;

        Set<Integer> rowSet = new HashSet();
        Set<Integer> colSet = new HashSet();
        Set<Integer> blockSet = new HashSet();


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //check rows
                int num = board[i][j] == "." ? -1 : Integer.parseInt(board[i][j]);
                if (num == -1)
                    continue;
                if (rowSet.contains(num)) {
                    return false;
                } else {
                    rowSet.add(num);
                }
            }
            rowSet.clear();
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                //check rows
                int num = board[i][j] == "." ? -1 : Integer.parseInt(board[i][j]);
                if (num == -1)
                    continue;
                if (colSet.contains(num)) {
                    return false;
                } else {
                    colSet.add(num);
                }
            }
            colSet.clear();
        }

        int kRow = 0;
        for (int k = 0; k < 9; k++) {
            int k3Col = (3 * k) % 9;
            if (k3Col == 0 && k > 0) {
                kRow += 3;
            }

            int k3Row = (kRow % 3) * 3 + 3;

            for (int i = kRow; i < kRow + 3; i++) {
                for (int j = k3Col; j < k3Col + 3; j++) {
                    //check rows
                    int num = board[i][j] == "." ? -1 : Integer.parseInt(board[i][j]);
                    if (num == -1)
                        continue;
                    if (blockSet.contains(num)) {
                        return false;
                    } else {
                        blockSet.add(num);
                    }
                }
            }
            blockSet.clear();
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] board = {
                {"8", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        String[][] board2 = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};

        String[][] board3 = {
                {".", ".", ".", ".", ".", ".", "5", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {"9", "3", ".", ".", "2", ".", "4", ".", "."},
                {".", ".", "7", ".", ".", ".", "3", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", "3", "4", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "3", ".", ".", "."},
                {".", ".", ".", ".", ".", "5", "2", ".", "."}
        };

        ValidSudoku vs = new ValidSudoku();
        System.out.println(vs.isValidSudoku3(board3));
    }
}
