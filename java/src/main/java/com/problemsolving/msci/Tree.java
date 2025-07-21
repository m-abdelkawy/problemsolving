package com.problemsolving.msci;

public class Tree {
    Node first;
    int sum = 0;

    public int getSum() {
        sum(first);
        return sum;
    }

    public void setFirst(int val) {
        this.first = new Node(val);
    }

    class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node addNode(Node current, int val){
        if(current == null)
            return new Node(val);

        if(val < current.value){
            current.left = addNode(current.left, val);
        }else if(val > current.value){
            current.right = addNode(current.right, val);
        }else{
            return current;
        }

        return current;
    }

    private void sum(Node root){
        if(root == null){
            return;
        }
        sum += root.value;

        sum(root.left);
        sum(root.right);
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6}; //21
        Tree tree = new Tree();
        tree.setFirst(input[0]);
        tree.addNode(null, input[0]);
        for (int i = 1; i < input.length; i++) {
            tree.addNode(tree.first, input[i]);
        }

        System.out.println(tree.getSum());
    }
}
