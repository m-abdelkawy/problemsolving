package com.problemsolving.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 * Link: https://leetcode.com/problems/minimum-depth-of-binary-tree
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 09.25.2024
 */
public class MinimumDepthOfBinaryTree {
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

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        else if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int qSize = queue.size();
            while(qSize > 0){
                qSize--;
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }

                if(node.left == null && node.right == null){
                    return depth;
                }

                queue.add(node.left);
                queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }

    public int minDepth3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        int depth = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode current = queue.poll();
                if(current.left == null && current.right == null){
                    return ++depth;
                }
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
