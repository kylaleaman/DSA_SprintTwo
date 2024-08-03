package com.keyin.binarytree.controller;

import ch.qos.logback.core.model.Model;
import com.keyin.binarytree.model.Tree;
import com.keyin.binarytree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TreeController {
    @Autowired
    private TreeService treeService;

    @GetMapping("/enter-numbers")
    public String showInputForm(Model model) {
        return "input";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam List<Integer> numbers, Model model) {
        Tree tree = treeService.createTree(numbers);
        model.addText("tree");
        return "result";
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<Tree> trees = treeService.getAllTrees();
        model.addText("trees");
        return "previous-trees";
    }
}
