package com.problemsolving.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalRecursive(root, res);
        return res;
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> res) {
        // base case
        if(root == null)
            return;

        inorderTraversalRecursive(root.left, res);
        res.add(root.val);
        inorderTraversalRecursive(root.right, res);
    }

    public static void main(String[] args) {

    }
}
