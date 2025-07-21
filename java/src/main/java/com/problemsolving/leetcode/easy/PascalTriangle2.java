package com.problemsolving.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * Link: https://leetcode.com/problems/pascals-triangle-ii/?envType=study-plan&id=data-structure-ii
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 18.09.2022
 */
public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        int init = 1;
        prev = prev;
        prev.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int n = i + 1;
            for (int j = 0; j < n; j++) {
                int left = j == 0 ? 0 : prev.get(j - 1);
                int right = j == n - 1 ? 0 : prev.get(j);
                int num = left + right;
                current.add(num);
            }
            prev.clear();
            prev.addAll(current);
            current.clear();
        }


        return prev;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> current = new ArrayList<>();

        int init = 1;
        List<Integer> prev = new ArrayList<>();
        current = prev;
        prev.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int n = i + 1;
            current = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int left = j == 0 ? 0 : prev.get(j - 1);
                int right = j == n - 1 ? 0 : prev.get(j);
                int num = left + right;
                current.add(num);
            }
            prev = current;
        }


        return current;
    }

    public List<Integer> getRow3(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        int init = 1;
        List<Integer> prev = new ArrayList<>();
        res = prev;
        prev.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int n = i + 1;
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int left = j == 0 ? 0 : prev.get(j - 1);
                int right = j == n - 1 ? 0 : prev.get(j);
                int num = left + right;
                current.add(num);
            }
            prev = current;
            res = current;
        }


        return res;
    }

    //Brute force
    // time limit exceeded
    public int getNum(int row, int col) {
        // base case
        if(row == 0 || col == 0 || col == row){
            return 1;
        }
        return getNum(row - 1, col - 1) + getNum(row - 1, col);
    }

    public List<Integer> getRow4(int rowIndex){
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            res.add(getNum(rowIndex, i));
        }
        return res;
    }

    // Dynamic programming approach
    public List<Integer> getRow5(int rowIndex){
        List<Integer> row = new ArrayList<>(rowIndex+1){
            {add(1);}
        };

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j)+ row.get(j-1));
            }
            row.add(1);
        }
        return row;
    }



    public static void main(String[] args) {
        PascalTriangle2 pt = new PascalTriangle2();
        System.out.println(pt.getRow5(3));
    }
}
