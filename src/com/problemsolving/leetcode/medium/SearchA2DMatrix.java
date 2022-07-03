package com.problemsolving.leetcode.medium;

/**
 * 74. Search a 2D Matrix
 * Link: https://leetcode.com/problems/search-a-2d-matrix/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 28.06.2022
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1])
            return false;
        int targetRow = 0;
        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0]) {
                targetRow = i;
            }
        }

        int[] row = matrix[targetRow];

        return linearSearch(row, target);
    }

    private boolean linearSearch(int[] a, int target) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (target == a[i]) {
                return true;
            }
            if (target < a[i]) {
                break;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = m - 1;
        int j = 0;

        while (i >= 0 && j < n) {
            if (target < matrix[i][j]) {
                i--;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int lo = 0;
        int hi = m * n - 1;

        return binarySearchRecursive(matrix, lo, hi, target);
    }

    private boolean binarySearchRecursive(int[][] matrix, int lo, int hi, int key) {
        if (lo > hi) {
            return false;
        }

        int mid = lo + (hi - lo) / 2;
        int r = mid / matrix[0].length;
        int c = mid % matrix[0].length;
        if (key == matrix[r][c]) {
            return true;
        }

        if (key < matrix[r][c])
            return binarySearchRecursive(matrix, lo, mid-1, key);
        else
            return binarySearchRecursive(matrix, mid + 1, hi, key);
    }

    private boolean binarySearchIterative(int[][] matrix, int lo, int hi, int key) {
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int r = mid / matrix[0].length;
            int c = mid % matrix[0].length;
            if(key == matrix[r][c]){
                return true;
            }
            if(key < matrix[r][c]){
                hi = mid - 1;
            }
            else{
                lo = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1}};
        int target = 2;
        SearchA2DMatrix sm = new SearchA2DMatrix();
        System.out.println(sm.searchMatrixBinarySearch(matrix, target));
    }
}
