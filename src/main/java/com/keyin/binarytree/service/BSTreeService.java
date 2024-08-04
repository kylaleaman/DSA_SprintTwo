package com.keyin.binarytree.service;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeNode;
import com.keyin.binarytree.repository.BSTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BSTreeService {

    @Autowired
    private BSTreeRepository bstRepository;

    public BSTree createTree(String numbers) {
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BSTree bst = new BSTree();
        numberList.forEach(bst::insert);

        numberList.forEach(number -> bstRepository.save(new BSTreeNode(number)));

        return bst;
    }

    public List<BSTreeNode> getPreviousTrees() {
        return bstRepository.findAll();
    }
}