package com.keyin.binarytree.model;

public class BSTreeNode {
    private int value;
    private BSTreeNode left;
    private BSTreeNode right;

    public BSTreeNode(int value) {
        this.value = value;
    }

    // Getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BSTreeNode getLeft() {
        return left;
    }

    public void setLeft(BSTreeNode left) {
        this.left = left;
    }

    public BSTreeNode getRight() {
        return right;
    }

    public void setRight(BSTreeNode right) {
        this.right = right;
    }
}
