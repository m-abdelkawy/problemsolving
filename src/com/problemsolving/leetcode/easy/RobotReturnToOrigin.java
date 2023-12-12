package com.problemsolving.leetcode.easy;


/**
 * 657. Robot Return to Origin
 * Link: https://leetcode.com/problems/robot-return-to-origin
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 13.05.2023
 */
public class RobotReturnToOrigin {
    public boolean judgeCircle1(String moves) {
        int[] position = {0, 0};
        int n = moves.length();
        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'R') {
                position[1]++;
            } else if (moves.charAt(i) == 'L') {
                position[1]--;
            } else if (moves.charAt(i) == 'U') {
                position[0]--;
            } else if (moves.charAt(i) == 'D') {
                position[0]++;
            }
        }
        return position[0] == 0 && position[1] == 0;
    }

    public boolean judgeCircle2(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
