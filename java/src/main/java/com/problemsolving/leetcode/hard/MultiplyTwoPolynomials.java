package com.problemsolving.leetcode.hard;

import java.util.Arrays;

public class MultiplyTwoPolynomials {
    public long[] multiply1(int[] poly1, int[] poly2){
        long[] res = new long[poly1.length + poly2.length - 1];
        for (int i = 0; i < poly1.length; i++) {
            for (int j = 0; j < poly2.length; j++) {
                res[i+j] += (long) poly1[i] * poly2[j];
            }
        }
        return res;
    }

    public long[] multiply(int[] poly1, int[] poly2){
        int n1 = poly1.length;
        int n2 = poly2.length;

        // make count even
        int maxLen = Math.max(n1, n2);
        int n = 1;
        while(n < maxLen){
            n *= 2;
        }

        int[] p1 = Arrays.copyOfRange(poly1, 0, n);
        int[] p2 = Arrays.copyOfRange(poly2, 0, n);

        return Arrays.copyOf(multiplyKaratsuba(p1, 0, p2, 0, n), n1 + n2 - 1);
    }

    private long[] multiplyKaratsuba(int[] poly1, int start1, int[] poly2, int start2, int n) {
        if (n <= 32) {
            return multiplyNaive(poly1, start1, poly2, start2, n);
        }
        int mid = n / 2;

        long[] d0e0 = multiplyKaratsuba(poly1, start1, poly2, start2, mid);
        long[] d1e1 = multiplyKaratsuba(poly1, start1 + mid, poly2, start2 + mid, mid);
        
        int[] sumD = new int[mid];
        int[] sumE = new int[mid];

        for (int i = 0; i < mid; i++) {
            sumD[i] = poly1[start1 + i] + poly1[start1 + mid + i];
            sumE[i] = poly2[start2 + i] + poly2[start2 + mid + i];
        }


        long[] z = multiplyKaratsuba(sumD, 0, sumE, 0, mid);

        long[] res = new long[2 * n - 1];

        for (int i = 0; i < d0e0.length; i++) {
            res[i] += d0e0[i];
        }

        for (int i = 0; i < z.length; i++) {
            res[i + mid] += z[i] - d0e0[i] - d1e1[i];
        }

        for (int i = 0; i < d1e1.length; i++) {
            res[i + 2 * mid] += d1e1[i];
        }

        return res;
    }

    // The fast, zero-allocation fallback for small arrays
    private long[] multiplyNaive(int[] p1, int start1, int[] p2, int start2, int n) {
        long[] res = new long[2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i + j] += (long) p1[start1 + i] * p2[start2 + j];
            }
        }
        return res;
    }

    private long[] multiplyRecursive(int[] poly1, int[] poly2, int n) {
        if (n == 1) {
            return new long[]{(long) poly1[0] * poly2[0]};
        }
        int mid = n / 2;
        int[] d0 = Arrays.copyOfRange(poly1, 0, mid);
        int[] d1 = Arrays.copyOfRange(poly1, mid, n);
        int[] e0 = Arrays.copyOfRange(poly2, 0, mid);
        int[] e1 = Arrays.copyOfRange(poly2, mid, n);

        long[] d0e0 = multiplyRecursive(d0, e0, mid);
        long[] d1e1 = multiplyRecursive(d1, e1, mid);
        long[] d0e1 = multiplyRecursive(d0, e1, mid);
        long[] d1e0 = multiplyRecursive(d1, e0, mid);

        long[] res = new long[2 * n - 1];

        for (int i = 0; i < d0e0.length; i++) {
            res[i] += d0e0[i];
        }

        for (int i = 0; i < d0e1.length; i++) {
            res[i + mid] += d0e1[i] + d1e0[i];
        }

        for (int i = 0; i < d1e1.length; i++) {
            res[i + 2 * mid] += d1e1[i];
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
