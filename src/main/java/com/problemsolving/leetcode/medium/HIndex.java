package com.problemsolving.leetcode.medium;

/**
 * 274. H-Index
 * Link: https://leetcode.com/problems/h-index/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 04.06.2022
 */
public class HIndex {
    public int hIndex1(int[] citations) {

        countSort(citations);

        int hindex = 0;
        int N = citations.length;

        for (int i = N - 1; i >= 0; i--) {
            if(citations[i] > hindex)
                hindex++;
            else
                break;
        }
        return hindex;
    }

    /**
     * sorts an array of integer in time O(n + m)
     * where n is the size of the input array and m is the size of the count array
     * @param a the input array to sort
     */
    private void countSort(int[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            if(a[i] < min){
                min = a[i];
            }
            if(a[i] > max){
                max = a[i];
            }
        }

        int countLen = max - min + 1;
        int[] count = new int[countLen];
        for (int i = 0; i < N; i++) {
            count[a[i] - min]++;
        }

        int pos = 0;
        for (int i = 0; i < countLen; i++) {
            for (int j = 0; j < count[i]; j++) {
                a[pos++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] citations = {94,40,49,65,21,21,106,80,92,81,679,4,61,6,237,12,72,74,29,95,265,35,47,1,61,397,52,72,37,51,1,81,45,435,7,36,57,86,81,72};
        HIndex index = new HIndex();
        System.out.println(index.hIndex1(citations));
    }
}
