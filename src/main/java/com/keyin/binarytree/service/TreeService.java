package com.keyin.binarytree.service;

import com.keyin.binarytree.model.Tree;
import com.keyin.binarytree.model.TreeNode;
import com.keyin.binarytree.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {
    @Autowired
    private TreeRepository treeRepository;

    public Tree createTree(List<Integer> numbers) {
        TreeNode root = constructTree(numbers);
        String treeStructure = serializeTree(root);
        String numbersStr = numbers.toString();
        Tree tree = new Tree();
        tree.setNumbers(numbersStr);
        tree.setTreeStructure(treeStructure);
        return treeRepository.save(tree);
    }

    private TreeNode constructTree(List<Integer> numbers) {
        TreeNode root = null;
        for (int number : numbers) {
            root = insert(root, number);
        }
        return root;
    }

    private TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.getValue()) {
            root.setLeft(insert(root.getLeft(), value));
        } else {
            root.setRight(insert(root.getRight(), value));
        }
        return root;
    }

    private String serializeTree(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.getValue()).append(",");
        serialize(node.getLeft(), sb);
        serialize(node.getRight(), sb);
    }

    public List<Tree> getAllTrees() {
        return treeRepository.findAll();
    }
}
