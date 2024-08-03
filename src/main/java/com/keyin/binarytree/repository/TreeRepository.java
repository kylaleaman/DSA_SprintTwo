package com.keyin.binarytree.repository;

import com.keyin.binarytree.model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {
    List<Tree> findByNumbers(String numbers);
    List<Tree> findByTreeStructureContaining(String value);

}
