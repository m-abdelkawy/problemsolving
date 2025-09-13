package com.problemsolving.leetcode.medium;

/**
 * 48. Rotate Image
 * Link: https://leetcode.com/problems/rotate-image
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 17.03.2023
 */
public class RotateImage {
    public void rotate1(int[][] matrix) {
        int m = matrix.length;
        int n  = matrix[0].length;

        // 01. transpose
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // 02. reverse columns
        for (int i = 0; i < m; i++) {
            int j = 0, k = n - 1;
            while(j < k){
                swap(matrix, i, j++, i, k--);
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int m = matrix.length;
        int n  = matrix[0].length;

        // 01. transpose
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // 02. reverse columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n/2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2){
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
