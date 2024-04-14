package com.problemsolving.freecodecamp;

import java.util.*;

/*
* a -------> c
* |          |
* |          |
* v          v
* b          e
* |
* |
* v
* d ------> f
*
*
*
*
* */

public class GraphAlgorithms {
    Map<String, List<String>> graph = new HashMap<>();

    {
        graph.put("a", List.of("b", "c"));
        graph.put("b", List.of("d"));
        graph.put("c", List.of("e"));
        graph.put("d", List.of("f"));
        graph.put("e", List.of());
        graph.put("f", List.of());
    }

    //abdfce or acebdf
    private void depthFirstSearchIterative(Map<String, List<String>> graph, String source) {
        Stack<String> stack = new Stack<>();
        stack.push(source);

        while (stack.size() > 0) {
            String current = stack.pop();
            System.out.println(current);
            List<String> lstAdjacent = graph.get(current);
            for (String adj: lstAdjacent) {
                stack.push(adj);
            }
        }
    }

    private void depthFirstSearchRecursive(Map<String, List<String>> graph, String source){
        System.out.println(source);
        List<String> lstAdjacent = graph.get(source);
        for (String adj: lstAdjacent) {
            depthFirstSearchRecursive(graph, adj);
        }
    }

    //abcdef or acbedf
    private void breadthFirstSearch(Map<String, List<String>> graph, String source){
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        while(queue.size() > 0){
            String current = queue.remove();
            System.out.println(current);
            List<String> lstAdjacent = graph.get(current);
            for (String adj: lstAdjacent) {
                queue.add(adj);
            }
        }
    }

    public static void main(String[] args) {
        GraphAlgorithms ga = new GraphAlgorithms();
        System.out.println("--------------Depth First Iterative---------------");
        ga.depthFirstSearchIterative(ga.graph, "a");
        System.out.println("--------------Depth First Recursive---------------");
        ga.depthFirstSearchRecursive(ga.graph, "a");
        System.out.println("-----------------------------");
        System.out.println("--------------Breadth First Recursive---------------");
        ga.breadthFirstSearch(ga.graph, "a");
    }
}
