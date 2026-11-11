package com.problemsolving.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortArrayTest {
    private final SortArray solver = new SortArray();

    @Test
    void sortsTypicalUnsortedArray() {
        int[] nums = {5, 1, 4, 2, 3};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, solver.sortArray_selection(nums));
    }

    @Test
    void handlesAlreadySortedInput() {
        int[] nums = {-3, -1, 0, 2, 7};
        assertArrayEquals(new int[]{-3, -1, 0, 2, 7}, solver.sortArray_selection(nums));
    }

    @Test
    void handlesDuplicatesAndNegatives() {
        int[] nums = {4, -1, 4, 0, -1, 2};
        assertArrayEquals(new int[]{-1, -1, 0, 2, 4, 4}, solver.sortArray_selection(nums));
    }

    @Test
    void handlesEmptyAndSingleValueInputs() {
        assertArrayEquals(new int[]{}, solver.sortArray_selection(new int[]{}));
        assertArrayEquals(new int[]{42}, solver.sortArray_selection(new int[]{42}));
    }
}