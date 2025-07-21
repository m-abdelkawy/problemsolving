package com.problemsolving.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class TwoSum5InputIsABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set){
        if(root == null)
            return false;

        int first = root.val;
        if(set.contains(k - first))
            return true;

        set.add(first);

        return find(root.left, k, set) || find(root.right, k, set);
    }

    public static void main(String[] args) {

    }
}
