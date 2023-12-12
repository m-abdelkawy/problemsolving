package com.problemsolving.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Link: https://leetcode.com/problems/pascals-triangle/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 26.06.2022
 */
public class PascalTriangle {
    /**
     * Time Complexity: O(numRows^2)
     * Space Complexity: O(1)
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = Arrays.asList(1);
        res.add(lst);
        for (int i = 1; i < numRows; i++) {
            lst = new ArrayList<>();
            List<Integer> prevList = res.get(i-1);

            for (int j = 0; j < i+1; j++) {
                int leftIndex  = j-1;
                int rightIndex = j;

                int leftNum = leftIndex >= 0? prevList.get(leftIndex):0;
                int rightNum = rightIndex < i? prevList.get(rightIndex):0;

                lst.add(leftNum + rightNum);
            }

            res.add(lst);
        }

        return res;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if(numRows >= 1)
            res.add(Arrays.asList(1));

        for(int i = 1; i < numRows; i++){
            List<Integer> lst = new ArrayList<>();
            List<Integer> prevRow = res.get(i-1);
            for(int j = 0; j < i+1; j++){
                int leftIndex = j-1 >= 0? j-1:0;
                int rightIndex = j<i?j:j-1;
                if(leftIndex == rightIndex){
                    lst.add(prevRow.get(leftIndex));
                }else{
                    lst.add(prevRow.get(leftIndex) + prevRow.get(rightIndex));
                }
            }
            res.add(lst);
        }

        return res;
    }

    public List<List<Integer>> generate3(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> lst = List.of(1);
        res.add(lst);
        List<Integer> previous = null;

        for(int i = 1; i < numRows; i++){
            previous = res.get(i - 1);
            lst = new ArrayList<>();
            for(int j = 0; j < i+1; j++){
                int left = j == 0? 0 : previous.get(j-1);
                int right = j == i? 0 : previous.get(j);
                lst.add(left + right);
            }
            res.add(lst);
        }

        return res;
    }

    public List<List<Integer>> generateDp(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> lst = List.of(1);
        res.add(lst);

        for (int rowIndex = 1; rowIndex < numRows; rowIndex++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = res.get(rowIndex - 1);
            row.add(1);
            for(int j = 1; j < rowIndex; j++){
                row.add(prev.get(j-1) + prev.get(j));
            }
            row.add(1);
            res.add(row);
        }

        return res;
    }
}
