package com.problemsolving.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    //Definition for a binary tree node.
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

    public boolean isSymmetric(TreeNode root) {
        //DFS
        if(root == null)
            return true;

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right){
        if(left == null || right == null)
            return left == right;

        if(left.val != right.val)
            return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
