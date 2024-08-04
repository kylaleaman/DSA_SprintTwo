package com.keyin.binarytree.model;

public class BSTree {
    private BSTreeNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private BSTreeNode insertRecursive(BSTreeNode current, int value) {
        if (current == null) {
            return new BSTreeNode(value);
        }
        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));
        }
        return current;
    }

    public BSTreeNode getRoot() {
        return root;
    }
}

