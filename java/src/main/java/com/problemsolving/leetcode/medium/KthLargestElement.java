package com.problemsolving.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 215. Kth Largest Element in an array
 * Ling: https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Gets the Kth Largest element in an array
 * Solution is based on quickSort like implementation
 *
 * Quick-select takes linear time on average
 * Intuitively, each partitioning step splits the array approximately in half:
 * N + N/2 + N/4 + .... + 1 ~= 2N compares
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 02.06.2022
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numsAsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.shuffle(numsAsList);

        return select(numsAsList.stream().mapToInt(Integer::intValue).toArray(), nums.length - k);
    }

    private int select(int[] a, int k) {
        int lo = 0, hi = a.length - 1;

        while (lo < hi) {
            int j = partition(a, lo, hi);
            if (k < j) {
                hi = j - 1;
            } else if (k > j) {
                lo = j + 1;
            } else {
                return a[k];
            }
        }
        return a[k];
    }

    private int partition(int[] a, int lo, int hi) {
        int partitionElm = a[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i] < partitionElm) {
                if (i == hi) break;
            }
            while (a[--j] > partitionElm) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement k = new KthLargestElement();
        int[] a = {3,2,3,1,2,4,5,5,6};
        System.out.println(k.findKthLargest(a, 4));
    }
}
