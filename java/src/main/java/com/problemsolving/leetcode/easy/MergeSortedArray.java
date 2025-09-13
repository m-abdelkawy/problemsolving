package com.problemsolving.leetcode.easy;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * Link: https://leetcode.com/problems/merge-sorted-array/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 26.06.2022
 */
public class MergeSortedArray {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int[] res = new int[m+n];
        int i = 0, j = 0, k = 0;
        while(k < m+n){
            if(nums1[i] <= nums2[j] && i < m){
                res[k++] = nums1[i++];
                if(i == m){
                    while(j < n){
                        res[k++] = nums2[j++];
                    }
                }
            }else{
                res[k++] = nums2[j++];
                if(j == n){
                    while(i < m){
                        res[k++] = nums1[i++];
                    }
                }
            }
        }
        for(int l = 0; l < m+n; l++){
            nums1[l] = res[l];
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int[] aux = new int[m+n];
        System.arraycopy(nums1, 0, aux, 0, m+n);
        int i=0, j = 0;

        for (int k = 0; k < len; k++) {
            if(i>m-1){
                nums1[k] = nums2[j++];
            }
            else if(j > n-1){
                nums1[k] = aux[i++];
            }
            else if(aux[i] <= nums2[j]){
                nums1[k] = aux[i++];
            }else{
                nums1[k] = nums2[j++];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;

        while(i >= 0 && j >=0){
            if(nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }

        while(j >= 0){
            nums1[k--] = nums2[j--];
        }

        System.out.println(Arrays.toString(nums1));
    }


    public static void main(String[] args) {
        int[] nums1 = {4,5,6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;

        MergeSortedArray msa = new MergeSortedArray();
        //msa.merge(nums1, m, nums2, n);
        //msa.merge2(nums1, m, nums2, n);
//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;
        msa.merge2(nums1, m, nums2, n);
    }
}
