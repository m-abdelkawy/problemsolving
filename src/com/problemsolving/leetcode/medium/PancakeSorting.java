package com.problemsolving.leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 969. Pancake Sorting
 * Link: https://leetcode.com/problems/pancake-sorting/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 20.01.2023
 */
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();

        for (int i = arr.length; i > 0; i--) {
            int index = find(arr, i);

            if(index == i - 1){
                continue;
            }

            if(index != 0){
                res.add(index + 1);
                flip(arr, index + 1);
            }

            res.add(i);
            flip(arr, i);
        }

        return res;
    }

    private void flip(int[] arr, int k){
        int i = 0, j = k - 1;
        while(i < j){
            swap(arr, i++, j--);
        }
    }
    
    private int find(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {4, 2, 3, 1};

        PancakeSorting ps = new PancakeSorting();
        //ps.flip(arr, 3);
        ps.pancakeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
