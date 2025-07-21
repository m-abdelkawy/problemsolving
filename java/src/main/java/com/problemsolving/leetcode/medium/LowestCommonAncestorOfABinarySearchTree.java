package com.problemsolving.leetcode.medium;

public class LowestCommonAncestorOfABinarySearchTree {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentValue = root.val;

        int pVal = p.val;

        int qVal = q.val;

        if(pVal > parentValue && qVal > parentValue)
            return lowestCommonAncestor(root.right, p, q);
        else if(pVal<parentValue && qVal < parentValue)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
}
