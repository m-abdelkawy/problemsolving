package com.problemsolving.leetcode.easy;

import java.util.*;

public class FloodFill {

    static Map<String, List<String>> graph;
    boolean[][] visited;

    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        formGraph(image);
        dfs(image, sr, sc, color);
        return image;
    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        int srcColor = image[sr][sc];
        if(srcColor != color){
            dfs(image, sr, sc, srcColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length];

        Stack<String> stack = new Stack<>();
        stack.push(sr + "-" + sc);

        int srcColor = image[sr][sc];
        image[sr][sc] = color;

        while (!stack.isEmpty()) {
            String current = stack.pop();

            String[] split = current.split("-");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            visited[x][y] = true;

            List<String> lstAdjacent = graph.get(current);
            int size = lstAdjacent.size();
            for (int i = 0; i < size; i++) {
                split = lstAdjacent.get(i).split("-");
                x = Integer.parseInt(split[0]);
                y = Integer.parseInt(split[1]);
                if (image[x][y] == srcColor && !visited[x][y]) {
                    stack.push(x + "-" + y);
                    image[x][y] = color;
                }
            }

        }
    }

    private void formGraph(int[][] image) {
        graph = new HashMap<>();
        int m = image.length;
        int n = image[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String current = i + "-" + j;
                // check top
                if (i - 1 >= 0) {
                    addEdge(current, (i - 1) + "-" + j);
                }

                // check bottom
                if (i + 1 < m) {
                    addEdge(current, (i + 1) + "-" + j);
                }

                // check left
                if (j - 1 >= 0) {
                    addEdge(current, i + "-" + (j - 1));
                }

                // check right
                if (j + 1 < n) {
                    addEdge(current, i + "-" + (j + 1));
                }
            }
        }
    }

    private void addEdge(String src, String dest) {
        if (graph.containsKey(src)) {
            graph.get(src).add(dest);
        } else {
            List<String> adjacents = new ArrayList<>();
            adjacents.add(dest);
            graph.put(src, adjacents);
        }
    }

    /*--------------------------------------------------*/
    private void dfs(int[][] image, int r, int c, int srcColor, int color) {
        if (image[r][c] == srcColor) {
            image[r][c] = color;
            if (r >= 1) dfs(image, r - 1, c, srcColor, color);
            if (c >= 1) dfs(image, r, c - 1, srcColor, color);
            if (r < image.length - 1) dfs(image, r + 1, c, srcColor, color);
            if (c < image[0].length - 1) dfs(image, r, c + 1, srcColor, color);
        }
    }

    public static void main(String[] args) {

    }
}
