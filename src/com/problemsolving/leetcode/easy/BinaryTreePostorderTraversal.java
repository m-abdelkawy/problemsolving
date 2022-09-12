package com.problemsolving.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversalRecursive(root, res);
        return res;
    }

    private void postorderTraversalRecursive(TreeNode root, List<Integer> res) {
        // base case
        if(root == null)
            return;

        postorderTraversalRecursive(root.left, res);
        postorderTraversalRecursive(root.right, res);
        res.add(root.val);
    }

    public static void main(String[] args) {

    }
}
