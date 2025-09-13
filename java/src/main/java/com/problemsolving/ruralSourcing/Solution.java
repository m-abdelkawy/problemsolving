package com.problemsolving.ruralSourcing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    class DistantObj implements Comparable<DistantObj>{
        private int dist;
        private int power;

        public DistantObj(int dist, int power) {
            this.dist = dist;
            this.power = power;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        @Override
        public int compareTo(DistantObj o) {
            return Comparator.comparing(DistantObj::getDist)
                    .thenComparing(DistantObj::getPower)
                    .compare(this, o);
        }
    }
    public int solution(int[] D, int[] C, int P) {
        // write your code in Java SE 8
        int n = C.length;
        DistantObj[] objs= new DistantObj[n];
        for (int i = 0; i < n; i++) {
            objs[i] = new DistantObj(D[i], C[i]);
        }
        Arrays.sort(objs);
        for (int i = 0; i < n; i++) {
            System.out.println(objs[i].power + ": " + objs[i].dist);
        }
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += objs[i].power;
            if(sum <= P)
                count++;
            else
                break;
        }
        return count;
    }
    /*
    int n = C.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            treeMap.put(D[i], C[i]);
        }

        int count = 0;
        int sumPower = 0;

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            sumPower += entry.getValue();
            if(sumPower <= P){
                count++;
            }else{
                break;
            }
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }



        return count;
     */

    public static void main(String[] args) {
        Solution soln = new Solution();
        int[] d1 = {5, 11, 1, 3};
        int[] c1 = {6, 1, 3, 2};
        int p1 = 7;

        System.out.println(soln.solution(d1, c1, p1));
        System.out.println("***********************************");

        int[] d2 = {10,15,1};
        int[] c2 = {10,1,2};
        int p2 = 3;

        System.out.println(soln.solution(d2, c2, p2));
        System.out.println("***********************************");

        int[] d3 = {5,5,5,5};
        int[] c3 = {8,3,3,4};
        int p3 = 6;

        System.out.println(soln.solution(d3, c3, p3));
        System.out.println("***********************************");

        int[] d4 = {11,18,1};
        int[] c4 = {9,18,8};
        int p4 = 7;

        System.out.println(soln.solution(d4, c4, p4));
        System.out.println("***********************************");

        int[] d5 = {1,4,2,5};
        int[] c5 = {4,9,2,3};
        int p5 = 19;

        System.out.println(soln.solution(d5, c5, p5));
        System.out.println("***********************************");
    }
}
