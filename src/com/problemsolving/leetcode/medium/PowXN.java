package com.problemsolving.leetcode.medium;

import javax.xml.transform.Source;

/**
 * 50. Pow(x, n)
 * Link: https://leetcode.com/problems/powx-n
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 23.05.2023
 */
public class PowXN {
    public double myPow1(double x, int n) {
        double res = 1.0;
        long posN = n;
        if (posN < 0) {
            posN = posN * -1;
        }
        while (posN > 0) {
            if (posN % 2 == 1) {
                res *= x;
                posN--;
            } else {
                x *= x;
                posN /= 2;
            }
        }

        if (n < 0) {
            res = (double) (1.0) / (double) (res);
        }
        return res;
    }

    public double myPow2(double x, int n) {
        if (x < -10000 || x > 10000) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }


        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        if(n %2 == 1){
            return x * myPow2(x,n-1);
        }else{
            return myPow2(x*x, n/2);
        }
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = -2147483648;

        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow2(x, n));
    }
}
