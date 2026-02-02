package com.problemsolving.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindGreatestCommonDivisorOfArrayTest {

    @Test
    void findGCDOfTypicalArray(){
        FindGreatestCommonDivisorOfArray solver = new FindGreatestCommonDivisorOfArray();
        int[] nums = new int[]{2, 5, 6, 9, 10};
        int result = solver.findGCD(nums);
        assertEquals(2, result);
    }

    @Test
    void findsGcdWhenAllNumbersShareFactor() {
        FindGreatestCommonDivisorOfArray solver =
                new FindGreatestCommonDivisorOfArray();

        int[] nums = {8, 16, 32, 64};
        int result = solver.findGCD(nums);

        assertEquals(8, result);
    }
}