package com.problemsolving.leetcode.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= i+k && j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.add(nums[i]) == false)
                return true;
            if(set.size() == k+1){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])){
                return true;
            }
            if(set.size() == k+1){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
