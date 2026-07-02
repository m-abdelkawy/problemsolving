package com.problemsolving.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 547. Number of Provinces
 * Link: https://leetcode.com/problems/number-of-provinces
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 2026.07.02
 *
 * @tags Union-Find, Graph, DFS, BFS
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int[] id = new int[n];
        int[] sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(isConnected[i][j] == 1){
                    if(i == j) continue;
                    union(i, j, id, sz);
                }
            }
        }

        int count = 0;
        Set<Integer> freq = new HashSet<>();
        for (int i = 0; i < id.length; i++) {
            freq.add(root(id, i));
        }
        return freq.size();
    }

    private void union(int i, int j, int[] id, int[] sz){
        int rootI = root(id, i);
        int rootJ = root(id, j);

        if(rootI == rootJ) return;

        if(sz[rootI] <= sz[rootJ]){
            id[rootI] = rootJ;
            sz[rootJ] += sz[rootI];
        } else{
            id[rootJ] = rootI;
            sz[rootI] += sz[rootJ];
        }
    }

    private int root(int[] id, int index){
        while(index != id[index]){
            //path compression: point to the grandparent
            id[index] = id[id[index]];
            index = id[index];
        }
        return index;
    }

    public static void main(String[] args) {

    }
}
