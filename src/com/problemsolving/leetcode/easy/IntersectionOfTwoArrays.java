package com.problemsolving.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 350. Intersection of Two Arrays II
 * Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 26.06.2022
 */
public class IntersectionOfTwoArrays {
    /**
     * O(nlogn + mlogm) solution
     * @param nums1 1st Array
     * @param nums2 2nd array
     * @return intersection of the 2 arrays
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = k; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    res.add(nums1[i]);
                    k = j + 1;
                    break;
                }
            }
        }
        return res.stream().mapToInt(num -> num.intValue()).toArray();
    }

    /**
     * O(nlogn + mlogm) solution
     * @param nums1 1st Array
     * @param nums2 2nd array
     * @return intersection of the 2 arrays
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> lst = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = k; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    lst.add(nums1[i]);
                    k = j + 1;
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

    /**
     * Time Complexity: O(nlogn + mlogm)
     * Space Complexity: from O(nlogn + mlogm) to O(n + m) depending on the sorting alg.
     * @param nums1 1st Array
     * @param nums2 2nd array
     * @return intersection of the 2 arrays
     */
    public int[] intersect3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    /**
     * Time Complexity: O(n+m)
     * Space Complexity: O(n) for the HashMap extra space
     * @param nums1 1st Array
     * @param nums2 2nd array
     * @return intersection of the 2 arrays
     */
    public int[] intersect4(int[] nums1, int[] nums2) {
        List<Integer> lst = new ArrayList<>();

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(frequencyMap.containsKey(nums1[i])){
                frequencyMap.put(nums1[i], frequencyMap.get(nums1[i])+1);
                continue;
            }
            frequencyMap.put(nums1[i], 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if(frequencyMap.containsKey(nums2[i]) && frequencyMap.get(nums2[i]) > 0){
                lst.add(nums2[i]);
                frequencyMap.put(nums2[i], frequencyMap.get(nums2[i])-1);
            }
        }
        return listToArray(lst);
    }

    /**
     * Time Complexity: O(n+m)
     * Space Complexity: O(min(n, m)) for the HashMap extra space
     * @param nums1 1st Array
     * @param nums2 2nd array
     * @return intersection of the 2 arrays
     */
    public int[] intersect5(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect5(nums2, nums1);
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer i: nums1) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        int k = 0;
        for (Integer i: nums2) {
            int count = frequencyMap.getOrDefault(i, 0);
            if(count > 0){
                nums1[k++] = i;
                frequencyMap.put(i, count - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    private int[] listToArray(List<Integer> lst){
        int n = lst.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = lst.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();
//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection.intersect3(nums1, nums2)));
    }
}
