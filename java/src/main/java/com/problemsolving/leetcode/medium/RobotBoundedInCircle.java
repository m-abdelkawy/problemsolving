package com.problemsolving.leetcode.medium;

/**
 * 1041. Robot Bounded In Circle
 * Link: https://leetcode.com/problems/robot-bounded-in-circle
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 13.05.2023
 */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int[] pos = {0, 0};
        String[] directions = {"North", "East", "South", "West"};
        int dir = 0;
        char[] chars = instructions.toCharArray();
        for (char c: chars) {
            if(c == 'G'){
                if(directions[dir].equals(directions[0])){
                    pos[1]++;
                }else if(directions[dir].equals(directions[1])){
                    pos[0]++;
                }else if(directions[dir].equals(directions[2])){
                    pos[1]--;
                }else if(directions[dir].equals(directions[3])){
                    pos[0]--;
                }
            }
            else if(c == 'L'){
                dir--;
                if(dir < 0){
                    dir = 3;
                }
            }else if(c == 'R'){
                dir++;
                if(dir > 3){
                    dir = 0;
                }
            }
        }

        //basically the robot is bounded in a circle if either
        //1. it ends back at the origin
        //2. it does not face north after one full instruction set (eventually loops when the instruction set is repeated)
        return (pos[0] == 0 && pos[1] == 0) || dir != 0;
    }

    public static void main(String[] args) {
        String dir = "GL";
        RobotBoundedInCircle r = new RobotBoundedInCircle();
        System.out.println(r.isRobotBounded(dir));
    }
}
