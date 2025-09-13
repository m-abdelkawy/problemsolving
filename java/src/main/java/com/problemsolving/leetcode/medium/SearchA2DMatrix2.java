package com.problemsolving.leetcode.medium;

/**
 * 240. Search a 2D Matrix II
 * Link: https://leetcode.com/problems/search-a-2d-matrix-ii
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 18.03.2023
 */


public class SearchA2DMatrix2 {
    /**
     * Brute Force Algorithm
     * Time Complexity: O(mn)
     * Space Complexity: O(1)
     *
     * @param matrix input matrix
     * @param target search target
     * @return true if target exists, false otherwise
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    /*--------------------------------------Binary Search Algorithm--------------------------------------*/

    /**
     * Binary Search Algorithm
     * Time Complexity: O(log(n!))
     * Space Complexity: O(1)
     *
     * @param matrix input matrix
     * @param target search target
     * @return true if target exists, false otherwise
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int smallerDim = Math.min(m, n);
        for (int i = 0; i < smallerDim; i++) {
            boolean foundVertical = binarySearch(matrix, target, i, true);
            boolean foundHorizontal = binarySearch(matrix, target, i, false);
            if (foundVertical || foundHorizontal)
                return true;
        }

        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lo = start;
        int hi = vertical ? m - 1 : n - 1;

        if (vertical) {
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (matrix[mid][start] == target) {
                    return true;
                } else if (target < matrix[mid][start]) {
                    hi = mid - 1;
                } else if (target > matrix[mid][start]) {
                    lo = mid + 1;
                }
            }
        } else {
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (matrix[start][mid] == target) {
                    return true;
                } else if (target < matrix[start][mid]) {
                    hi = mid - 1;
                } else if (target > matrix[start][mid]) {
                    lo = mid + 1;
                }
            }
        }
        return false;
    }

    /*--------------------------------------Divide and Conquer Algorithm--------------------------------------*/

    /**
     * Divide and Conquer Algorithm
     * Time Complexity: O(log(n!))
     * Space Complexity: O(1)
     *
     * @param matrix input matrix
     * @param target search target
     * @return true if target exists, false otherwise
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;

        return searchRecursively(matrix, target, 0, 0, matrix[0].length, matrix.length);
    }

    private boolean searchRecursively(int[][] matrix, int target, int left, int up, int right, int down) {
        // base case
        if(left > right || up > down){
            return false;
        }
        if(target < matrix[up][left] || target > matrix[down][right]){
            return false;
        }

        int mid = left + (right - left)/2;
        int row = up;

        while(row <= down && matrix[row][mid] <= target){
            if(matrix[row][mid] == target){
                return true;
            }
            row++;
        }

        return searchRecursively(matrix, target, left, row, mid - 1, down) ||
                searchRecursively(matrix, target, mid+1, up, right, row-1);
    }
}
