package com.problemsolving.leetcode.medium;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 73. Set Matrix Zeroes
 * Link: https://leetcode.com/problems/set-matrix-zeroes
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 17.05.2023
 */
public class SetMatrixZeroes {
    public void setZeroes1(int[][] matrix) {
        List<String> zeroes = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    zeroes.add(i + "-" + j);
                }
            }
        }

        for (int i = 0; i < zeroes.size(); i++) {
            String[] pos = zeroes.get(i).split("-");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            // make row zeros
            for (int j = 0; j < n; j++) {
                matrix[x][j] = 0;
            }
            // make col zeroes
            for (int j = 0; j < m; j++) {
                matrix[j][y] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
