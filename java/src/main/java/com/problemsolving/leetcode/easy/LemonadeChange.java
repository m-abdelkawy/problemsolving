package com.problemsolving.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 860. Lemonade Change
 * Link: https://leetcode.com/problems/lemonade-change
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 18.05.2023
 */
public class LemonadeChange {
    public boolean lemonadeChange1(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bills[i] == 10) {
                int count5 = map.getOrDefault(5, 0);
                if (count5 == 0) {
                    return false;
                }
                map.put(10, map.getOrDefault(10, 0) + 1);
                map.put(5, map.getOrDefault(5, 0) - 1);
            } else if (bills[i] == 20) {
                int count5 = map.getOrDefault(5, 0);
                int count10 = map.getOrDefault(10, 0);
                if (count10 > 0 && count5 > 0) {
                    map.put(10, map.getOrDefault(10, 0) - 1);
                    map.put(5, map.getOrDefault(5, 0) - 1);
                } else if (count5 >= 3) {
                    map.put(5, map.getOrDefault(5, 0) - 3);
                } else {
                    return false;
                }
                map.put(20, map.getOrDefault(20, 0) + 1);

            }
        }
        return true;
    }

    public boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        LemonadeChange lc = new LemonadeChange();
        System.out.println(lc.lemonadeChange1(bills));
    }
}
