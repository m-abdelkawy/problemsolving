package com.problemsolving.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1502. Can Make Arithmetic Progression From Sequence
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 10.05.2023
 */
public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression1(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i + 2] - arr[i + 1] == arr[i + 1] - arr[i]) {
                continue;
            }
            return false;
        }
        return true;
    }

    public boolean canMakeArithmeticProgression2(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == diff) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean canMakeArithmeticProgression3(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        Set<Integer> nums = new HashSet<>();

        int n = arr.length;

        if((max - min) % (n-1) != 0){
            return false;
        }

        int diff = (max - min) / (n - 1);

        if(diff == 0){
            return true;
        }

        for (int i = 0; i < n; i++) {
            if ((arr[i] - min) % diff == 0) {
                nums.add(arr[i]);
                continue;
            }
            return false;
        }
        return nums.size() == n;
    }

    public static boolean canMakeArithmeticProgression4(int[] arr) {
        int mn = 0;
        int mx = 0;
        boolean[] mem = new boolean[arr.length];
        int n = arr.length - 1;
        for(int i = 1; i <= n; i++)
        {
            if(arr[i] < arr[mn])
            {
                mn = i;
            }
            else if(arr[i] > arr[mx])
            {
                mx = i;
            }
        }

        if(arr[mn] == arr[mx])
            return true;

        if((arr[mx] - arr[mn]) % n != 0)
            return false;
        int d = (arr[mx] - arr[mn]) / n;

        mem[0] = true;
        mem[n] = true;

        for(int i = 0; i <= n; i++)
        {
            if(i == mn || i == mx)
                continue;
            if((arr[i] - arr[mn]) % d != 0)
                return false;
            int di = (arr[i] - arr[mn]) / d;
            if(mem[di])
                return false;
            mem[di] = true;
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] arr = {1,2, 2,4};
        int[] arr = {2,10,7,8,3};
        System.out.println(canMakeArithmeticProgression4(arr));
    }
}
