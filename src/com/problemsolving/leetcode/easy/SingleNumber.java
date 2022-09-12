package com.problemsolving.leetcode.easy;

import java.util.*;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                continue;
            }
            map.put(nums[i], 1);
        }

        int res = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sumNums = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            sumNums += nums[i];
        }
        // int sumSingle = set.stream().mapToInt(x->x).sum();
        int sumSingle = 0;
        for (Integer num : set) {
            sumSingle += num;
        }
        return 2 * sumSingle - sumNums;
    }

    public int singleNumber3(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (lst.contains(nums[i]))
                lst.remove(Integer.valueOf(nums[i]));
            else
                lst.add(nums[i]);
        }
        return lst.get(0);
    }

    public int singleNumber4(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a = a^num;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(1^3);
    }
}
