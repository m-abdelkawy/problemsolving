package com.problemsolving.leetcode.hard;

// https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
public class WordSearch {
    static int[] x = {0, 1, 1};
    static int[] y = {1, 0, 1};

    static int solution(char[][] board, String word) {
        int R = board.length;
        int C = board[0].length;

        int count = 0;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (board[row][col] == word.charAt(0) &&
                        search2D(board, row, col, word, R, C, 0))
                    count++;
                if (board[row][col] == word.charAt(0) &&
                        search2D(board, row, col, word, R, C, 1))
                    count++;
                if (board[row][col] == word.charAt(0) &&
                        search2D(board, row, col, word, R, C, 2))
                    count++;
            }
        }

        return count;
    }

    static boolean search2D(char[][] grid, int row,
                            int col, String word, int R, int C, int dir) {

        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();


        int k, rd = row + x[dir], cd = col + y[dir];

        for (k = 1; k < len; k++) {
            if (rd >= R || rd < 0 || cd >= C || cd < 0)
                break;


            if (grid[rd][cd] != word.charAt(k))
                break;

            rd += x[dir];
            cd += y[dir];
        }
        if (k == len)
            return true;
        return false;
    }

    public static void main(String[] args) {
        char[][] arr = {{'s', 'o', 's', 'o'},
                {'s', 'o', 'o', 's'},
                {'s', 's', 's', 's'}};

        System.out.println(solution(arr, "sos"));
    }
}
