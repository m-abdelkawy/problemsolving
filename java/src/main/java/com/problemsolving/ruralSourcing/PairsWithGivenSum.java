package com.problemsolving.ruralSourcing;


import java.lang.reflect.Array;
import java.util.*;

public class PairsWithGivenSum {
    public static List<List<Integer>> getPairs(int[] arr, int sum) {
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    pairs.add(List.of(arr[i], arr[j]));
                }
            }
        }
        return pairs;
    }

    public static List<List<Integer>> getPairsUnique(int[] arr, int sum) {
        List<List<Integer>> pairs = new ArrayList<>();

        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sumTwo = arr[i] + arr[j];
            if (sumTwo == sum) {
                while (i < j && arr[i] == arr[i + 1]) {
                    i++;
                }
                while (i < j && arr[j] == arr[j - 1]) {
                    j--;
                }
                pairs.add(List.of(arr[i], arr[j]));
                i++;
                j--;
            } else if (sumTwo < sum) {
                i++;
            } else {
                j--;
            }
        }

        return pairs;
    }

    public static List<List<Integer>> getPairsHashMap(int[] arr, int sum) {
        List<List<Integer>> pairs = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            int second = sum - arr[i];
            if (map.containsKey(second)) {
                pairs.add(List.of(first, second));
            }
            map.put(first, map.getOrDefault(first, 0) + 1);
        }

        return pairs;
    }

    public static List<List<Integer>> getPairsBinarySearch(int[] arr, int sum) {
        List<List<Integer>> pairs = new ArrayList<>();

        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            int second = sum - arr[i];
            if (binarySearchIterative(arr, second, i + 1, arr.length - 1)) {
                pairs.add(List.of(first, second));
            }
        }

        return pairs;
    }

    private static boolean binarySearchRecursive(int[] nums, int target, int lo, int hi) {
        // base case
        if (lo > hi)
            return false;
        int mid = lo + ((hi - lo) / 2);
        if (target == nums[mid]) {
            return true;
        } else if (target > nums[mid]) {
            return binarySearchRecursive(nums, target, mid + 1, hi);
        } else {
            return binarySearchRecursive(nums, target, lo, mid - 1);
        }
    }

    private static boolean binarySearchIterative(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] arr = {1, 5, 7, -1, 5};
        int[] arr = {1, 1, 1, 5, 7, -1, 5};
        int sum = 6;
        System.out.println(getPairs(arr, sum));
        System.out.println(getPairsUnique(arr, sum));
        System.out.println(getPairsHashMap(arr, sum));
        System.out.println(getPairsBinarySearch(arr, sum));
    }
}
