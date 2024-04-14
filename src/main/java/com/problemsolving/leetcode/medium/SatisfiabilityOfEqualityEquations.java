package com.problemsolving.leetcode.medium;

/**
 * Problem: <a href="https://leetcode.com/problems/satisfiability-of-equality-equations/">satisfiability-of-equality-equations</a>
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * Solved using Union find algorithm
 */
public class SatisfiabilityOfEqualityEquations {
    int[] parent;
    int[] treesize;

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        treesize = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            treesize[i] = 1;
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }

        for (String eq : equations) {
            if(eq.charAt(1) == '!'){
                if(connected(eq.charAt(0)-'a', eq.charAt(3)-'a')){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean connected(int i, int j) {
        return root(i) == root(j);
    }

    private int root(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    private void union(int i, int j) {
        if (!connected(i, j)) {
            int rooti = root(i);
            int rootj = root(j);

            if (treesize[i] < treesize[j]) {
                parent[rooti] = j;
                treesize[j] += treesize[i];
            } else {
                parent[rootj] = i;
                treesize[i] += treesize[j];
            }
        }
    }

    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations see = new SatisfiabilityOfEqualityEquations();
        String[] arr = {"a==b","e==c","b==c","a!=e"};
        System.out.println(see.equationsPossible(arr));

//        arr = new String[]{"b==a", "a==b"};
//        System.out.println(see.equationsPossible(arr));
//
//        arr = new String[]{"c==c", "b==d", "x!=z"};
//        System.out.println(see.equationsPossible(arr));
//
//        arr = new String[]{"a!=b", "b!=c", "c!=a"};
//        System.out.println(see.equationsPossible(arr));
    }
}
