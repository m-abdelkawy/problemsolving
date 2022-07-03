package com.problemsolving.leetcode.easy;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 * Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 26.06.2022
 */
public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = k; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    res.add(nums1[i]);
                    k = j+1;
                    break;
                }
            }
        }
        return res.stream().mapToInt(num -> num.intValue()).toArray();
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> lst = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = k; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    lst.add(nums1[i]);
                    k = j+1;
                    break;
                }
            }
        }
        int[] res = new int[lst.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = lst.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();
        int[] nums1 = {1,2,2,1};
        int[]nums2 = {2,2};
        System.out.println(Arrays.toString(intersection.intersect(nums1, nums2)));
    }
}
