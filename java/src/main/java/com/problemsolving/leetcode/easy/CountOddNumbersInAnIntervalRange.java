package com.problemsolving.leetcode.easy;


/**
 * 1523. Count Odd Numbers in an Interval Range
 * Link: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 18.05.2023
 */

// time limit exceeded
public class CountOddNumbersInAnIntervalRange {
    //time limit exeeded case 82/84
    public int countOdds1(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if(i % 2 == 1){
                count++;
            }
        }
        return count;
    }

    public int countOdds2(int low, int high) {
        if(low % 2 == 0){
            low++;
        }

        return low > high? 0 : (high - low)/2 + 1;
    }
}
