package com.problemsolving.leetcode.easy;

/**
 * 701. Insert into a Binary Search Tree
 * Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/?envType=study-plan&id=data-structure-i
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 10.09.2022
 */

public class InsertIntoABinarySearchTree {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode ptr = root;
        while (ptr != null) {
            if (val < ptr.val) {
                if (ptr.left == null) {
                    ptr.left = new TreeNode(val);
                    return root;
                }
                ptr = ptr.left;
            } else {
                if (ptr.right == null) {
                    ptr.right = new TreeNode(val);
                    return root;
                }
                ptr = ptr.right;
            }
        }
        return new TreeNode(val);
    }

    public static void main(String[] args) {

    }
}
