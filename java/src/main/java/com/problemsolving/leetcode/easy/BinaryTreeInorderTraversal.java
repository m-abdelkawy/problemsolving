package com.problemsolving.leetcode.easy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversa
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 09.10.2022
 */
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

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalRecursive(root, res);
        return res;
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> res) {
        // base case
        if (root == null)
            return;

        inorderTraversalRecursive(root.left, res);
        res.add(root.val);
        inorderTraversalRecursive(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal3MorrisMethod(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode current = root;
        TreeNode pre;
        while(current != null){
            if(current.left == null){
                res.add(current.val);
                current = current.right;
            }else{
                pre = current.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = current;
                TreeNode temp = current;
                current = current.left;
                temp.left = null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
