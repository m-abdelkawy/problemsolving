package com.problemsolving.leetcode.medium;

import java.util.*;

/**
 * 256. Merge Intervals
 * Link: https://leetcode.com/problems/merge-intervals/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 19.02.2023
 */
public class MergeIntervals {
    public int[][] merge1(int[][] intervals) {
        Comparator<int[]> byStart = (int[] a, int[] b) -> Integer.compare(a[0], b[0]);

        Arrays.sort(intervals, byStart);

        List<int[]> lst = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length - 1 && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[++i][1]);
            }
            lst.add(new int[]{start, end});
        }

        return lst.toArray(new int[lst.size()][2]);
    }

    public int[][] merge2(int[][] intervals) {
        Comparator<int[]> byStart = (int[] a, int[] b) -> Integer.compare(a[0], b[0]);

        Arrays.sort(intervals, byStart);
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }

    /*-----------------------------graph solution------------------------------*/

    private Map<int[], List<int[]>> graph;
    private Map<Integer, List<int[]>> nodesInComponent;
    private Set<int[]> visited;

    public int[][] merge3(int[][] intervals) {
        buildGraph(intervals);
        buildComponent(intervals);

        List<int[]> merged = new LinkedList<>();
        for (int i = 0; i < nodesInComponent.size(); i++) {
            List<int[]> compNodes = nodesInComponent.get(i);
            int[] intervalMerged = mergeNodes(compNodes);
            merged.add(intervalMerged);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private boolean overlap(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }



    private void buildGraph(int[][] intervals) {
        graph = new HashMap<>();
        for (int[] interval : intervals) {
            graph.put(interval, new LinkedList<>());
        }

        for (int[] interval1 : intervals) {
            for (int[] interval2 : intervals) {
                if (overlap(interval1, interval2)) {
                    graph.get(interval1).add(interval2);
                    graph.get(interval2).add(interval1);
                }
            }
        }
    }

    private int[] mergeNodes(List<int[]> nodes) {
        int minStart = Integer.MAX_VALUE;
        int maxEnd = Integer.MIN_VALUE;
        for (int[] node : nodes) {
            minStart = Math.min(minStart, node[0]);
            maxEnd = Math.max(maxEnd, node[1]);
        }
        return new int[]{minStart, maxEnd};
    }

    private void markComponentDFS(int[] start, int compNumber){
        Stack<int[]> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()){
            int[] node = stack.pop();
            if(!visited.contains(node)){
                visited.add(node);

                if(nodesInComponent.get(compNumber) == null){
                    nodesInComponent.put(compNumber, new LinkedList<>());
                }
                nodesInComponent.get(compNumber).add(node);

                for(int[] child: graph.get(node)){
                    stack.add(child);
                }
            }
        }
    }

    private void buildComponent(int[][] intervals){
        nodesInComponent = new HashMap<>();
        visited = new HashSet<>();
        int compNumber = 0;
        for(int[] interval: intervals){
            if(!visited.contains(interval)){
                markComponentDFS(interval, compNumber);
                compNumber++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
