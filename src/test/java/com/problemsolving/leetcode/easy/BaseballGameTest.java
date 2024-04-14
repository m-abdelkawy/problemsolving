package com.problemsolving.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    void calPoints1() {
        String[] ops = {"5","2","C","D","+"};
        BaseballGame bbg = new BaseballGame();
        assertEquals(30, bbg.calPoints1(ops));
    }

    @Test
    void calPoints_stack() {
        String[] ops = {"5","2","C","D","+"};
        BaseballGame bbg = new BaseballGame();
        assertEquals(30, bbg.calPoints_stack(ops));
    }
}