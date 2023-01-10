package com.problemsolving.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * Link: https://leetcode.com/problems/number-of-islands/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 10.01.2022
 */
public class NumberOfIslands {
    /*-------------------------------------DFS Recursive-------------------------------------*/

    /**
     * Time Complexity: O(m * n)
     *
     * @param grid array of characters
     * @return number of islands
     */
    public int numIslands1(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid == null || m == 0 || n == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = 'x';

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
    /*-------------------------------------BFS-------------------------------------*/

    /**
     * Time Complexity: O(m * n)
     * Space Complexity: O(min(m, n))
     *
     * @param grid array of characters
     * @return number of islands
     */
    public int numIslands2(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid == null || m == 0 || n == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = 'x'; //mark visited

                    Queue<Integer> adjacents = new LinkedList<>();

                    adjacents.add(i * n + j);
                    while (!adjacents.isEmpty()) {
                        int id = adjacents.remove();
                        int row = id / n;
                        int col = id % n;

                        // check top
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            adjacents.add((row - 1) * n + col);
                            grid[row - 1][col] = 'x';
                        }

                        // check bottom
                        if (row + 1 < m && grid[row + 1][col] == '1') {
                            adjacents.add((row + 1) * n + col);
                            grid[row + 1][col] = 'x';
                        }

                        // check left
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            adjacents.add(row * n + (col - 1));
                            grid[row][col - 1] = 'x';
                        }

                        // check right
                        if (col + 1 < n && grid[row][col + 1] == '1') {
                            adjacents.add(row * n + (col + 1));
                            grid[row][col + 1] = 'x';
                        }
                    }
                }
            }
        }

        return count;
    }
}
