package net.callirgos.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class treeTest {

    @Test
    void convertToBinary() {
        //test input
        tree.TreeNode root = new tree.TreeNode(1);
        tree.TreeNode child1 = new tree.TreeNode(2);
        tree.TreeNode child2 = new tree.TreeNode(3);
        tree.TreeNode child3 = new tree.TreeNode(4);
        tree.TreeNode child4 = new tree.TreeNode(5);
        tree.TreeNode child5 = new tree.TreeNode(6);
        tree.TreeNode child6 = new tree.TreeNode(7);
        tree.TreeNode child7 = new tree.TreeNode(8);
        tree.TreeNode child8 = new tree.TreeNode(9);
        tree.TreeNode child9 = new tree.TreeNode(10);
        tree.TreeNode child10 = new tree.TreeNode(11);
        tree.TreeNode child11 = new tree.TreeNode(12);
        tree.TreeNode child12 = new tree.TreeNode(13);
        tree.TreeNode child13 = new tree.TreeNode(14);
        tree.TreeNode child14 = new tree.TreeNode(15);
        tree.TreeNode child15 = new tree.TreeNode(16);
        tree.TreeNode child16 = new tree.TreeNode(17);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);
        child1.children.add(child4);
        child1.children.add(child5);
        child1.children.add(child6);
        child1.children.add(child7);
        child2.children.add(child8);
        child2.children.add(child9);
        child3.children.add(child10);
        child3.children.add(child11);
        child3.children.add(child12);
        child4.children.add(child13);
        child5.children.add(child14);
        child5.children.add(child15);
        child5.children.add(child16);

        System.out.println("before");
        System.out.println(root.toString());
        System.out.println("after");
        tree.BTreeNode result = new tree().convertToBinary(root);
        System.out.println(result.toString());
        System.out.println("reverted");
        System.out.println(new tree().convertToNarray(result).toString());
    }
}