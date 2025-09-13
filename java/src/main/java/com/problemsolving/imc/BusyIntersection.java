package com.problemsolving.imc;

import java.util.*;
import java.util.stream.Collectors;

public class BusyIntersection {
    public static List<Integer> getResult(List<Integer> arrival, List<Integer> street) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

    public static List<Integer> getResult2(List<Integer> arrival, List<Integer> street) {
        Integer[] resArr = new Integer[arrival.size()];

        Queue<Integer> main = new PriorityQueue<>();
        Queue<Integer> firstAvenue = new PriorityQueue<>();

        String prevSecondAv = "";
        int i = 0, j = 1;
        if(arrival.get(i) != arrival.get(j)){
            prevSecondAv = street.get(i) == 0? "main": "1stAvenue";
        }else{
            prevSecondAv = street.get(i) == 1 || street.get(j) == 1? "1stAvenue": "main";
        }

        int count = 0;
        int prevSecond = 0;

        for (int k = 0; k < arrival.size(); k++) {
            if (street.get(k) == 0)
                main.add(arrival.get(k));
            else {
                firstAvenue.add(arrival.get(k));
            }
        }
        while (!main.isEmpty() || !firstAvenue.isEmpty()) {
            if (prevSecondAv == "1stAvenue") {
                int carTime = firstAvenue.remove();
                count += carTime;
                prevSecondAv = "1stAvenue";
                prevSecond = carTime;
                int index = findIndex(carTime, 1, arrival, street);
                resArr[index] = count;
            }
            else if(prevSecondAv == "main"){
                int carTime = main.remove();
                count += carTime;
                prevSecondAv = "main";
                prevSecond = carTime;
                int index = findIndex(carTime, 0, arrival, street);
                resArr[index] = count;
            }
        }
        return Arrays.stream(resArr).map(x -> x).collect(Collectors.toList());
    }

    private static int findIndex(int second, int av, List<Integer> arrival, List<Integer> street) {
        for (int i = 0; i < arrival.size(); i++) {
            if (arrival.get(i) == second && street.get(i) == av) {
                return i;
            }
        }
        return -1;
    }
}
