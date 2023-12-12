package com.problemsolving.leetcode.easy;

/**
 * 1572. Matrix Diagonal Sum
 * Link: https://leetcode.com/problems/matrix-diagonal-sum
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 16.05.2023
 */
public class MatrixDiagonalSum {
    public int diagonalSum1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == m - 1) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }

    public int diagonalSum2(int[][] mat) {
        int m = mat.length;

        int sum = 0;

        if (m % 2 != 0) {
            sum -= mat[m / 2][m / 2];
        }

        for (int i = 0; i < m; i++) {
            sum += mat[i][i];
            sum += mat[i][m - i - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        MatrixDiagonalSum mds = new MatrixDiagonalSum();
        System.out.println(mds.diagonalSum1(mat));
    }
}
