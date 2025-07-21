package com.problemsolving.leetcode.easy;

/**
 * 1232. Check If It Is a Straight Line
 * Link: https://leetcode.com/problems/check-if-it-is-a-straight-line
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 18.05.2023
 */
public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = getXDiff(coordinates[1], coordinates[0]);
        int deltaY = getYDiff(coordinates[1], coordinates[0]);

        for (int i = 2; i < coordinates.length; i++) {
            if(deltaX * getYDiff(coordinates[i], coordinates[0]) != deltaY * getXDiff(coordinates[i], coordinates[0])){
                return false;
            }
        }

        return true;
    }

    private int getXDiff(int[] a, int[] b){
        return b[0] - a[0];
    }

    private int getYDiff(int[] a, int[] b){
        return b[1] - a[1];
    }
}
