package com.problemsolving.leetcode.hard;

/**
 * 42. Trapping Rain Water
 * Link: https://leetcode.com/problems/container-with-most-water
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 26.03.2026
 */
public class TrappingRainWater {
    /**
     * Time Complexity: O(n^2) -> Exceeds time limits in some cases
     * Space Complexity: O(1)
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int sum = 0;
        int N = height.length;
        for (int i = 0; i < N; i++) {
            int maxLeft = 0, maxRight = 0;
            int left = 0, right = i + 1;
            while (left < i) {
                maxLeft = Math.max(maxLeft, height[left++]);
            }
            while (right <= N-1){
                maxRight = Math.max(maxRight, height[right++]);
            }
            sum += Math.max(0, Math.min(maxLeft, maxRight) - height[i]);
        }
        return sum;
    }

    /**
     * same idea as 238. Product of Array Except Self
     * Space complexity: O(n) for introducing prefix and suffix arrays
     * Time Complexity: O(n) for we loop only one, or precisely, 3 separate passes
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int sum = 0;
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        prefix[0] = height[0];
        suffix[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i+1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            int maxLeft = i > 0 ?  prefix[i-1] : 0;
            int maxRight = i < height.length - 1 ?  suffix[i+1] : 0;
            sum += Math.max(0, Math.min(maxLeft, maxRight) - height[i]);
        }
        return sum;
    }

    /**
     * same idea as 238. Product of Array Except Self
     * Space complexity: O(n) for introducing prefix and suffix arrays
     * Time Complexity: O(n) for we loop only one, or precisely, 3 separate passes
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int sum = 0, left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if(maxLeft < maxRight) {
                sum += Math.max(0, height[left] - maxLeft);
                left++;
            } else{
                sum += Math.max(0, height[right] - maxRight);
                right--;
            }
        }
        return sum;
    }

    /**
     * Approach: Two pointers with running max
     * Process from the limiting side — whichever max is smaller guarantees
     * the water at that position regardless of the opposite side.
     *
     * Time Complexity: O(n) single pass, each element visited at most once
     * Space complexity: O(1) only two pointers and two running max variables
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        int sum = 0, left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {

            if(maxLeft <= maxRight) {
                maxLeft = Math.max(maxLeft, height[left]);
                sum += maxLeft - height[left];
                left++;
            } else{
                maxRight = Math.max(maxRight, height[right]);
                sum += maxRight - height[right];
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap2(height));
    }
}
