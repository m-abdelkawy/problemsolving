package com.problemsolving.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversalRecursive(root, res);
        return res;
    }

    private void preorderTraversalRecursive(TreeNode root, List<Integer> res) {
        // base case
        if(root == null)
            return;

        res.add(root.val);
        preorderTraversalRecursive(root.left, res);
        preorderTraversalRecursive(root.right, res);
    }

    public static void main(String[] args) {

    }

}
