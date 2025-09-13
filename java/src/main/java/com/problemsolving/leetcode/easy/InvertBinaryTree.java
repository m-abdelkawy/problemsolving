package com.problemsolving.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 * Link: https://leetcode.com/problems/invert-binary-tree
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 09.10.2022
 */
public class InvertBinaryTree {
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

    public TreeNode invertTreeRecursive(TreeNode root) {
        if(root == null)
            return root;

        // swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);

        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()){
            TreeNode currentNode = q.poll();
            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;
            if(currentNode.left != null) q.add(currentNode.left);
            if(currentNode.right != null) q.add(currentNode.right);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
