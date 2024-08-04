package com.keyin.binarytree;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.service.BSTreeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BSTreeServiceTest {

    @Autowired
    private BSTreeService bsTreeService;

    @Test
    public void testTreeCreation() {
        BSTree bsTree = bsTreeService.createTree("4,2,6,1,5,8,2");
        assertNotNull(bsTree.getRoot());
    }

    @Test
    public void testEmptyInput() {
        BSTree bsTree = bsTreeService.createTree("");
        assertNull(bsTree.getRoot());
    }
}
