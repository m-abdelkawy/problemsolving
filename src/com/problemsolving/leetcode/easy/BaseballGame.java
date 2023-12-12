package com.problemsolving.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 682. Baseball Game
 * Link: https://leetcode.com/problems/baseball-game
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 11.05.2023
 */
public class BaseballGame {
    public int calPoints(String[] operations) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            if(operations[i].equals("+")){
                res.add(res.get(res.size() - 1) + res.get(res.size() - 2));
            }else if(operations[i].equals("D")){
                res.add(2 * res.get(res.size() - 1));
            } else if (operations[i].equals("C")) {
                res.remove(res.size() - 1);
            }else{
                Integer num = Integer.parseInt(operations[i]);
                res.add(num);
            }
        }
        return res.stream().mapToInt(c -> c.intValue()).sum();
    }

    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};
        BaseballGame bbg = new BaseballGame();
        System.out.println(bbg.calPoints(ops));
    }
}
