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
}
