package com.problemsolving.leetcode;

public class KthMissingPositiveNumber {

    //https://leetcode.com/problems/kth-missing-positive-number/

    private boolean linearSearchRecursive(int[] arr, int lo, int hi, int key) {
        if (lo > hi)
            return false;
        if (arr[lo] == key)
            return true;
        return linearSearchRecursive(arr, lo + 1, hi, key);
    }

    private boolean linearSearchIterative(int[] arr, int lo, int hi, int key) {
        for (int i = lo; i <= hi; i++) {
            if (arr[i] == key)
                return true;
        }
        return false;
    }

    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int number = 1;
        while (j < k) {
            if (i < arr.length && arr[i] == number) {
                i++;
            } else {
                j++;
            }
            number++;
        }
        return number - 1;
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber kthMissingPositiveNumber = new KthMissingPositiveNumber();
        int[] arr1 = {2, 3, 4, 7, 11};
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(kthMissingPositiveNumber.findKthPositive(arr1, 5));
        System.out.println(kthMissingPositiveNumber.findKthPositive(arr2, 2));
    }
}
