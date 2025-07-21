package com.problemsolving.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 * Link: https://leetcode.com/problems/non-overlapping-intervals
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 22.03.2023
 */
public class NonOverlappingIntervals {
    Comparator<int[]> byStart = (int[] a, int[] b) -> Integer.compare(a[0], b[0]);
    Comparator<int[]> byEnd = (int[] a, int[] b) -> Integer.compare(a[1], b[1]);

    public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals, byStart);
        return erase_Overlap_Intervals(-1, 0, intervals);
    }

    private int erase_Overlap_Intervals(int previous, int current, int[][] intervals) {
        if (current == intervals.length)
            return 0;

        int taken = Integer.MAX_VALUE, nottaken;

        if (previous == -1 || intervals[previous][1] <= intervals[current][0]) {
            taken = erase_Overlap_Intervals(current, current + 1, intervals);
        }

        nottaken = erase_Overlap_Intervals(previous, current + 1, intervals) + 1;

        return Math.min(taken, nottaken);
    }

    /*-------------------------------------DP-------------------------------------*/

    public boolean isOverlapping(int[] i, int[] j) {
        return i[1] > j[0];
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, byEnd);

        int[] taken = new int[intervals.length];

        taken[0] = 1;
        int ans = 1;
        for (int i = 1; i < taken.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (!isOverlapping(intervals[j], intervals[i])) {
                    max = Math.max(taken[j], max);
                }
            }
            taken[i] = max + 1;
            ans = Math.max(ans, taken[i]);
        }
        return intervals.length - ans;
    }

    /*-------------------------------------DP-------------------------------------*/

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        NonOverlappingIntervals noi = new NonOverlappingIntervals();

        System.out.println(noi.eraseOverlapIntervals1(intervals));
    }
}
