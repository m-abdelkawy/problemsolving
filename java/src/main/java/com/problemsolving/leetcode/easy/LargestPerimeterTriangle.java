package com.problemsolving.leetcode.easy;

import java.util.Arrays;
import java.util.Collections;

/**
 * 976. Largest Perimeter Triangle
 * Link: https://leetcode.com/problems/largest-perimeter-triangle
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 18.05.2023
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        return 0;
    }
}
