package com.problemsolving.leetcode.easy;

public class PathSum {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode root, int targetSum, int currentSum) {
        if (root == null)
            return false;

        currentSum += root.val;

        if (root.left == null && root.right == null) {
            return currentSum == targetSum;
        }

        return dfs(root.left, targetSum, currentSum) || dfs(root.right, targetSum, currentSum);
    }

    public static void main(String[] args) {

    }
}
