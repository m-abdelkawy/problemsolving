package com.problemsolving.leetcode.medium;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II
 * Link: https://leetcode.com/problems/spiral-matrix-ii
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 17.03.2023
 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 0;

        while(left <= right && top <= bottom){
            for (int i = left; i <= right; i++) {
                res[top][i] = ++num;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res[i][right] = ++num;
            }
            right--;

            //if (!(left < right) || !(top < bottom)) break;

            for (int i = right; i >= left; i--) {
                res[bottom][i] = ++num;
            }
            bottom--;

            for (int i = bottom; i >= top ; i--) {
                res[i][left] = ++num;
            }
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix2 sm = new SpiralMatrix2();
        System.out.println(Arrays.deepToString(sm.generateMatrix(3)));
    }
}
