package com.grokkingAlgorithms.chapter1;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target){
        int lo = 0;
        int hi = arr.length - 1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] < target){
                lo = mid + 1;
            } else{
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 15, 30, 54, 58, 64, 68, 78, 82, 95, 115};
        int target[] = {54, 55};

        for(int i = 0; i < target.length; i++){
            int index = binarySearch(arr, target[i]);
            if(index == -1){
                System.out.println("number: " + target[i] + " not found");
            } else{
                System.out.println("number: " + target[i] + " found at index: " + index);
            }
        }
    }
}
