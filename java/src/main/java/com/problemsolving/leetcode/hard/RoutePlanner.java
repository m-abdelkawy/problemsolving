package com.problemsolving.leetcode.hard;

import java.util.*;

public class RoutePlanner {

    static HashMap<String, ArrayList<String>> graph;

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix) {
        if(fromRow < 0 || fromColumn < 0 || toRow < 0 || toColumn < 0) {
            return false;
        }

        int nRows = mapMatrix.length;
        int nCols = mapMatrix[0].length;

        if(fromRow >= nRows || fromColumn >= nCols || toRow >= nRows || toColumn >= nCols) {
            return false;
        }
        if(mapMatrix[fromRow][fromColumn] == false || mapMatrix[toRow][toColumn] == false) {
            return false;
        }

        if(fromRow == toRow && fromColumn == toColumn) {
            return true;
        }

        formGraph(mapMatrix, nRows, nCols);
        return bfs(fromRow + "-" + fromColumn, toRow + "-" + toColumn);
    }


    public static void formGraph(boolean[][] mapMatrix, int nRows, int nCols) {
        graph = new HashMap<String, ArrayList<String>>();

        for(int i = 0; i < nRows; i++) {
            for(int j = 0; j < nCols; j++) {
                if(mapMatrix[i][j] == false) {
                    continue;
                }
                String currId = i + "-" + j;
                // check top
                if(i-1 >= 0) {
                    if(mapMatrix[i-1][j]== true) {
                        addEdge(currId, (i-1) + "-" + j);
                    }
                }

                //check bottom
                if(i+1 < mapMatrix.length) {
                    if(mapMatrix[i+1][j] == true) {
                        addEdge(currId, (i+1) + "-" + j);
                    }
                }

                //check left
                if(j-1 >= 0) {
                    if(mapMatrix[i][j-1] == true) {
                        addEdge(currId, i + "-" + (j-1));
                    }
                }

                //check right
                if(j+1 < mapMatrix[i].length) {
                    if(mapMatrix[i][j+1] == true) {
                        addEdge(currId, i + "-" + (j+1));
                    }
                }
            }
        }
    }

    public static void addEdge(String src, String dest) {
        if(graph.containsKey(src)) {
            graph.get(src).add(dest);
        } else {
            ArrayList<String> neighbor = new ArrayList<String>();
            neighbor.add(dest);
            graph.put(src, neighbor);
        }
    }

    public static boolean bfs(String start, String end) {
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();

        queue.add(start);
        visited.add(start);

        String curr;
        while(!queue.isEmpty()) {
            curr = queue.poll();

            if(curr.equals(end)) {
                return true;
            }

            if(!graph.containsKey(curr)) {
                return false;
            }

            for(String next : graph.get(curr)) {
                if(!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
