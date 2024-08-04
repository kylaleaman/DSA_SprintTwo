package com.keyin.binarytree.controller;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.service.BSTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BSTreeController {

    @Autowired
    private BSTreeService bstService;

    @GetMapping("/enter-numbers")
    public String showInputPage() {
        return "enterNumbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam("numbers") String numbers, Model model) {
        BSTree bst = bstService.createTree(numbers);
        model.addAttribute("tree", bst.getRoot());
        return "treeView";
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        model.addAttribute("trees", bstService.getPreviousTrees());
        return "previousTrees";
    }
}


