package com.problemsolving.creospan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {0,0,1,0,1,1,0,0,1,1,1,0,1};

        int maxCount = 0;
        int count = 0;


        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                count = 0;
            }else{
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}
