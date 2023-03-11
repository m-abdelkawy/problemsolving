package com.problemsolving.leetcode.medium;

/**
 * 264. Ugly Number II
 * Link: https://leetcode.com/problems/ugly-number-ii/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 04.02.2023
 */
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int index2 = 1, index3 =1, index5 =1;
        int factor2 = 2, factor3=3, factor5=5;
        ugly[0] = 1;
        for(int i = 0; i < n; i++){
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if(min == factor2){
                factor2 = 2* index2++;
            }
            else if(min == factor3){
                factor3 = 3*index3++;
            }else if(min == factor5){
                factor5 = 5*index5++;
            }
        }
        return ugly[n-1];
    }

    public static void main(String[] args) {

    }
}
