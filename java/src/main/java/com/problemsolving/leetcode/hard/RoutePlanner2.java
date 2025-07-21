package com.problemsolving.leetcode.hard;

import java.util.*;


public class RoutePlanner2 {
    static Map<String, ArrayList<String>> graph;

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        if (fromRow < 0 || fromColumn < 0 || toRow < 0 || toColumn < 0)
            return false;

        int nRows = mapMatrix.length;
        int nCols = mapMatrix[0].length;

        if (fromRow >= nRows || fromColumn >= nCols || toRow >= nRows || toColumn >= nCols)
            return false;

        if (mapMatrix[fromRow][fromColumn] == false || mapMatrix[toRow][toColumn] == false)
            return false;

        if (fromRow == toRow && fromColumn == toColumn)
            return true;

        formGraph(mapMatrix, nRows, nCols);
        String start = fromRow+"-"+fromColumn;
        String end = toRow +"-"+toColumn;
        return bfs(start, end);
    }

    private static boolean bfs(String start, String end) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        String currentNode = null;
        while(!queue.isEmpty()){
            currentNode = queue.poll();

            if(currentNode.equals(end))
                return true;

            if(!graph.containsKey(currentNode))
                return false;

            //visited.add(currentNode);
            List<String> lstAdjacent = graph.get(currentNode);
            for (String adjacent: lstAdjacent) {
                if(!visited.contains(adjacent)){
                    queue.add(adjacent);
                    visited.add(adjacent);
                }
            }
        }
        return false;
    }

    private static void formGraph(boolean[][] mapMatrix, int nRows, int nCols) {
        graph = new HashMap<>();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (mapMatrix[i][j] == false)
                    continue;

                String current = i + "-" + j;

                // check left
                if (j - 1 >= 0 && mapMatrix[i][j-1] == true) {
                    String adjacent = i + "-" + (j - 1);
                    addEdge(current, adjacent);
                }

                //check right
                if (j + 1 < mapMatrix[i].length && mapMatrix[i][j+1] == true) {
                    String adjacent = i + "-" + (j + 1);
                    addEdge(current, adjacent);
                }

                // check top
                if (i - 1 >= 0 && mapMatrix[i-1][j]==true) {
                    String adjacent = (i - 1) + "-" + j;
                    addEdge(current, adjacent);
                }

                // check bottom
                if (i + 1 < mapMatrix.length && mapMatrix[i+1][j]) {
                    String adjacent = (i + 1) + "-" + j;
                    addEdge(current, adjacent);
                }
            }
        }
    }

    private static void addEdge(String src, String dest) {
        if(!graph.containsKey(src)){
            graph.put(src, new ArrayList<>());
        }
        graph.get(src).add(dest);
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true, false, false},
                {true, true, false},
                {false, true, true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
