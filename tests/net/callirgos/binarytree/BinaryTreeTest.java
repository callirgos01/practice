package net.callirgos.binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree.TreeNode CreteTestBST() {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(50);

        //level 1
        root.left = new BinaryTree.TreeNode(40);
        root.right = new BinaryTree.TreeNode(60);
        //level2
        root.left.left = new BinaryTree.TreeNode(30);
        root.left.right = new BinaryTree.TreeNode(45);
        root.right.left = new BinaryTree.TreeNode(55);
        root.right.right = new BinaryTree.TreeNode(70);
        //level3
        root.left.left.left = new BinaryTree.TreeNode(20);
        root.left.left.right = new BinaryTree.TreeNode(35);
        root.left.right.left = new BinaryTree.TreeNode(44);
        root.left.right.right = new BinaryTree.TreeNode(46);
        root.right.left.left = new BinaryTree.TreeNode(54);
        root.right.left.right = new BinaryTree.TreeNode(56);
        root.right.right.left = new BinaryTree.TreeNode(69);
        root.right.right.right = new BinaryTree.TreeNode(71);

        return root;
    }

    @Test
    void inorder() {
        BinaryTree.TreeNode root = CreteTestBST();
        new BinaryTree().inorder(root);

    }

    @Test
    void inorder_rec() {
        BinaryTree.TreeNode root = CreteTestBST();
        System.out.print("inorder_rec ");
        new BinaryTree().inorder_rec(root);
    }

    @Test
    void preorder() {
        BinaryTree.TreeNode root = CreteTestBST();
        new BinaryTree().preorder(root);
    }

    @Test
    void postorder_rec() {
        BinaryTree.TreeNode root = CreteTestBST();
        System.out.print("postorder_rec ");
        new BinaryTree().postorder_rec(root);
    }

    @Test
    void preorder_rec() {
        BinaryTree.TreeNode root = CreteTestBST();
        System.out.print("preorder_rec ");
        new BinaryTree().preorder_rec(root);
    }

    @Test
    void levelorder() {
    }

    @Test
    void levelorder_rec() {
    }

    @Test
    void inorderToDoublyLinkedList() {
    }
}