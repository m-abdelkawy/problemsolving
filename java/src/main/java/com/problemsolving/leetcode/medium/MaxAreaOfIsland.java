package com.problemsolving.leetcode.medium;

public class MaxAreaOfIsland {
    int[][] grid;
    boolean[][] seen;

    private int area(int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || seen[row][col] || grid[row][col] == 0) {
            return 0;
        }

        seen[row][col] = true;
        return (1 + area(row + 1, col) + area(row - 1, col) + area(row, col - 1) + area(row, col + 1));
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, area(i, j));
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        MaxAreaOfIsland maxArea = new MaxAreaOfIsland();

        System.out.println(maxArea.maxAreaOfIsland(grid));
    }
}
