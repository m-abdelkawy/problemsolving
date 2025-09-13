package com.problemsolving.leetcode.easy;

import java.util.*;

public class FindIfPathExistsInGraph {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        seen = new boolean[n];
        formGraph(edges);
        return depthFirstSearchRecursive(source, destination);
    }

    private boolean depthFirstSearchIterative(int source, int destination) {
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        seen[source] = true;
        while (stack.size() > 0) {
            int current = stack.pop();
            if (current == destination) {
                return true;
            }
            List<Integer> lstAdjacent = graph.get(current);
            for (Integer adj : lstAdjacent) {
                if (!seen[adj]) {
                    stack.push(adj);
                    seen[adj] = true;
                }
            }
        }
        return false;
    }

    private boolean depthFirstSearchRecursive(int source, int destination) {
        if (source == destination) {
            return true;
        }
        if (!seen[source]) {
            seen[source] = true;
            List<Integer> lstAdjacent = graph.get(source);
            for (int adj : lstAdjacent) {
                if(depthFirstSearchRecursive(adj, destination)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean breadthFirstSearch(int source, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        seen[source] = true;

        while (queue.size() > 0) {
            int current = queue.remove();
            if (current == destination) {
                return true;
            }
            List<Integer> lstAdjacent = graph.get(current);
            for (Integer adj : lstAdjacent) {
                if (!seen[adj]) {
                    queue.add(adj);
                    seen[adj] = true;
                }
            }
        }
        return false;
    }

    private void formGraph(int[][] edges) {
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0, destination = 2;
        FindIfPathExistsInGraph pe = new FindIfPathExistsInGraph();
        System.out.println(pe.validPath(n, edges, source, destination));
    }
}
