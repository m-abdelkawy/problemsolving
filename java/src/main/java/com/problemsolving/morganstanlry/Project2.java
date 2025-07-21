package com.problemsolving.morganstanlry;

import java.util.List;

public class Project2 {
    public static void main(String[] args) {
        // 0, 1, 1, 2, 3, 5, 8, 13

        int n = 5;
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i)+"\t");
        }
    }

//    public static void fib();

    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
