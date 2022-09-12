package com.problemsolving.msci;

import java.util.*;

public class Solution {
    public boolean hasDuplicates(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public boolean hasDuplicates2(int[] arr){
        Arrays.sort(arr); //O(nlogn)
        int i = 0, j=1;
        while (i < arr.length && j < arr.length){
            if(arr[i] == arr[j]){
                return true;
            }
        }
        return false;
    }

    // [1,1,1,1, 1, 5,6,7,8] 5/9 > 50%
    public int occurenceMoreThan50Percent(int[] arr){
        Map<Integer, Integer> map = new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        //TreeMap // elements sorted
        //linkedhashmap // order of inserting
        int size = arr.length;

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue()/size > 0.5){
                return entry.getKey();
            }
        }

        return -1;
    }

    public boolean occurenceMoreThan50Percent2(int[] arr){
        int size = arr.length;
        Arrays.sort(arr);
        for (int i = 0, j = size/2; j < arr.length; i++, j++) {
            if(arr[i] == arr[j]){
                return true;
            }
        }
        return false;
    }

    public int binarySearchReturnIndex(int[] arr, int x){
        return binarySearchReturnIndex(arr, 0, arr.length, x);
    }

    public int binarySearchReturnIndex(int[] arr, int lo, int hi, int x){

        //base case
        if(lo > hi){
            return lo;
        }

        int mid = (lo+hi)/2;

        if(x == arr[mid]){
            return mid;
        }

        else if(x < arr[mid]){
            return binarySearchReturnIndex(arr, lo, mid-1, x);
        }

        else {
            return binarySearchReturnIndex(arr, mid+1, hi, x);
        }
    }


}
