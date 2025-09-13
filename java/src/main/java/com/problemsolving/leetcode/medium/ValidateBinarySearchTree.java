package com.problemsolving.leetcode.medium;

import java.util.Stack;

public class ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        //return dfs(root);
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    private boolean dfs(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode predecessor = null;
        //stack.add(root);
        while (root != null || !stack.isEmpty()) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if(predecessor != null && predecessor.val >= root.val)
                return false;

            predecessor = root;

            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
