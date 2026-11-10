package com.problemsolving.leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTwoPolynomialsTest {
    private final MultiplyTwoPolynomials solver = new MultiplyTwoPolynomials();

    @Test
    void multipliesPolynomialsWithMultipleTerms() {
        assertArrayEquals(
                new long[]{4, 13, 22, 15},
                solver.multiply(new int[]{1, 2, 3}, new int[]{4, 5})
        );
    }

    @Test
    void multipliesConstantAndLinearPolynomials() {
        assertArrayEquals(
                new long[]{6, -12},
                solver.multiply(new int[]{3}, new int[]{2, -4})
        );
    }

    @Test
    void handlesNegativeCoefficientsAndCancellation() {
        assertArrayEquals(
                new long[]{1, 0, -1},
                solver.multiply(new int[]{1, -1}, new int[]{1, 1})
        );
    }

    @Test
    void handlesZeroPolynomial() {
        assertArrayEquals(
                new long[]{0, 0, 0},
                solver.multiply(new int[]{0, 0}, new int[]{2, 3})
        );
    }

    @Test
    void usesLongForProductsThatExceedIntRange() {
        assertArrayEquals(
                new long[]{4_611_686_014_132_420_609L},
                solver.multiply(new int[]{Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE})
        );
    }

}