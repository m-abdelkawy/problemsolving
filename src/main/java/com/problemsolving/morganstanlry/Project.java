package com.problemsolving.morganstanlry;

import java.util.*;
import java.util.stream.Collectors;

public class Project {
    public static void main(String[] args) {
        List<Integer> lst1 = List.of(1, 2, 3);
        List<Integer> lst2 = List.of(3, 4, 5);

        System.out.println(intersection2(lst1, lst2));
        System.out.println(union(lst1, lst2));

        String str = "hello";

    }

    public static List<Integer> intersection(List<Integer> lst1, List<Integer> lst2){
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < lst1.size(); i++){
            for (int j = 0; j < lst2.size(); j++) {
                if(lst1.get(i) == lst2.get(j)){
                    res.add(lst1.get(i));
                }
            }
        }

        return res;
    }

    // O(N)
    public static List<Integer> intersection2(List<Integer> lst1, List<Integer> lst2){
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < lst1.size(); i++) {
            frequencyMap.put(lst1.get(i), frequencyMap.getOrDefault(lst1.get(i), 0) + 1);
        }

        for (int i = 0; i < lst2.size(); i++) {
            if(frequencyMap.containsKey(lst2.get(i)) && frequencyMap.get(lst2.get(i)) > 0){
                res.add(lst2.get(i));
                frequencyMap.put(lst2.get(i), frequencyMap.get(lst2.get(i)) - 1);
            }
        }

        return res;
    }

    public static List<Integer> union(List<Integer> lst1, List<Integer> lst2){
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < lst1.size(); i++) {
            res.add(lst1.get(i));
        }

        for (int i = 0; i < lst2.size(); i++) {
            res.add(lst2.get(i));
        }

        return res.stream().collect(Collectors.toList());
    }

}
