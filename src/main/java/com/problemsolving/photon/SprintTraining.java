package com.problemsolving.photon;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SprintTraining {
    public static int getMostVisited(int n, List<Integer> sprints) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < sprints.size() - 1; i++){

            int start = Math.min(sprints.get(i), sprints.get(i + 1));
            int end = Math.max(sprints.get(i), sprints.get(i + 1));;


            for(int num = start; num <= end; num++){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int res = -1;
        int maxOccurrence = -1;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == maxOccurrence && entry.getKey() < res){
                maxOccurrence = entry.getValue();
                res = entry.getKey();
                continue;
            }
            if(entry.getValue() > maxOccurrence){
                maxOccurrence = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    private static List<Integer> getValuesInBetween(List<Integer> sprints, int index){
        //int[i]
        int start = sprints.get(index);
        int end = sprints.get(index + 1);

        List<Integer> lstVals = new ArrayList<>();
        if(start <= end){
            for(int i = start; i <= end; i++){
                lstVals.add(i);
            }
        }else{
            for(int i = start; i >= end; i--){
                lstVals.add(i);
            }
        }
        return lstVals;
    }

    public static void main(String[] args) {
        int n = 10;
        List<Integer> lst = List.of(4, 1, 5, 10, 3);

        System.out.println(getMostVisited(n, lst));
    }
}
