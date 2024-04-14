package com.problemsolving.leetcode.easy;

/**
 * 1446. Consecutive Characters
 * https://leetcode.com/problems/consecutive-characters/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 17.02.2023
 */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        int maxCount = 0;
        int count = 0;
        char previous = ' ';
        for(int i = 0; i < s.length(); i++){
            if(chars[i] == previous){
                count++;
            }else{
                previous = chars[i];
                count = 1;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
