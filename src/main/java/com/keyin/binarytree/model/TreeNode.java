package com.keyin.binarytree.model;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    // Intialize constructor
    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Default constructor
    public TreeNode() {
        this.left = null;
        this.right = null;
    }

    // Getter and Setter for value
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Getter and Setter for left
    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    // Getter and Setter for right
    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    // Method to print values in order
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(value + " ");
        if (right != null) {
            right.printInOrder();
        }
    }

    // Method to get string representation of tree
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(this, sb, "", "");
        return sb.toString();
    }

    private void toStringHelper(TreeNode node, StringBuilder sb, String prefix, String childrenPrefix) {
        if (node != null) {
            sb.append(prefix);
            sb.append(node.value);
            sb.append('\n');
            if (node.left != null || node.right != null) {
                if(node.left != null) {
                    toStringHelper(node.left, sb, childrenPrefix +"├── ", childrenPrefix + "│   ");
                } else {
                    sb.append(childrenPrefix + "├── null\n");
                }
                if (node.right != null) {
                    toStringHelper(node.right, sb, childrenPrefix + "└── ", childrenPrefix + "    ");
                } else {
                    sb.append(childrenPrefix + "└── null\n");
                }
            }
        }
    }
}
