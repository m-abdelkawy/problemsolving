package com.problemsolving.leetcode.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 566. Reshape the Matrix
 * Link: https://leetcode.com/problems/reshape-the-matrix/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 26.06.2022
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if(r*c != m*n)
            return mat;

        int[][] res = new int[r][c];

        int i=0, j = 0;
        int multi = r*c;
        for (int k = 0; k < r; k++) {
            for (int l = 0; l < res[k].length; l++) {
                res[k][l] = mat[i][j++];
                if(j >= n){
                    i++;
                    j = 0;
                }
            }
        }
        return res;
    }

    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m * n != r * c)
            return mat;

        int[][] res = new int[r][c];

        for(int i = 0; i < r * c; i++){
            res[i/c][i%c] = mat[i/n][i%n];
        }

        return res;
    }



    public void display2DArray(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args  ) {
        int[][] input = {{1,2},{3,4}};
        int r = 1, c = 4;
        ReshapeTheMatrix reshaper = new ReshapeTheMatrix();
        System.out.println("Original Array: ");
        reshaper.display2DArray(input);
        System.out.println();
        System.out.println("After transformation: ");
        reshaper.display2DArray(reshaper.matrixReshape(input, r, c));
    }
}
