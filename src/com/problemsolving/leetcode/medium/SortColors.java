package com.problemsolving.leetcode.medium;

import java.util.Arrays;

/**
 * 75. Sort Colors
 * link: https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int N = nums.length;
        int[] aux = new int[N];
        sort(nums, aux, 0, N - 1);
    }

    private void sort(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);

        if (a[mid] < a[mid + 1])
            return;

        merge(a, aux, lo, mid, hi);
    }

    private void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[j] < aux[i])
                a[k] = aux[j++];
            else if (aux[i] <= aux[j])
                a[k] = aux[i++];
        }
    }

    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, current = 0, p2 = n-1;

        while(current <= p2){
            if(nums[current] == 0){
                swap(nums, p0++, current++);
            }else if(nums[current] == 2){
                swap(nums, p2--, current);
            }else{
                current++;
            }
        }
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        //int[] a = {2, 0, 2, 1, 1, 0};
        int[] a = {2, 0, 1};
        SortColors s = new SortColors();
        s.sortColors2(a);
        System.out.println(Arrays.toString(a));
    }
}
