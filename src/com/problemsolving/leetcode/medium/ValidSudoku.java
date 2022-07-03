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
                int k = 3 * (i/3) + (j/3);
                if(value != '.'){
                    if(!seen.add(value + " row " + i)
                    || !seen.add(value + " column " + j)
                    ||!seen.add(value + " block " + k)){
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

        ValidSudoku vs = new ValidSudoku();
        System.out.println(vs.isValidSudoku(board));
    }
}
