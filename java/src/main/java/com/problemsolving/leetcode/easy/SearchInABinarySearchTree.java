package com.problemsolving.leetcode.easy;

/**
 * 700. Search in a Binary Search Tree
 * Link: https://leetcode.com/problems/search-in-a-binary-search-tree/?envType=study-plan&id=data-structure-i
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 10.07.2022
 */
public class SearchInABinarySearchTree {
    //Definition for a binary tree node.
    private class TreeNode {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;

        if(root.val == val)
            return root;

        if(val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    public static void main(String[] args) {

    }
}
