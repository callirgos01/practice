package net.callirgos.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    // iterative
    public void inorder(TreeNode root) {
        System.out.print("inorder ");
        Stack<TreeNode> stack = new Stack<>();
        while( root != null ) {
            stack.push(root);
            root = root.left;
        }
        //found min
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.printf("%d,",current.val);
            //go right
            //find min
            TreeNode next = current.right;
            while(next != null) {
                stack.push(next);
                next = next.left;
            }
        }
    }
    //recursive
    public void inorder_rec(TreeNode root) {
        if(root!=null) {
            inorder_rec(root.left);
            System.out.printf("%d,",root.val);
            inorder_rec(root.right);
        }
    }

    public void preorder(TreeNode root) {
        System.out.print("preorder ");
        Stack<TreeNode> stack = new Stack<>();
        while( root != null ) {
            stack.push(root);
            root = root.right;
        }
        //found min
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.printf("%d,",current.val);
            //go right
            //find min
            TreeNode next = current.left;
            while(next != null) {
                stack.push(next);
                next = next.right;
            }
        }
    }

    public void preorder_rec(TreeNode root ) {
        if(root!=null) {
            System.out.printf("%d,",root.val);
            inorder_rec(root.left);
            inorder_rec(root.right);
        }
    }

    public void postorder_rec(TreeNode root ) {
        if(root!=null) {
            inorder_rec(root.right);
            inorder_rec(root.left);
            System.out.printf("%d,",root.val);
        }
    }

    public void levelorder(TreeNode root) {

    }

    public void levelorder_rec(TreeNode root) {

    }

    public void inorderToDoublyLinkedList( TreeNode root) {

    }
    private static class  BinaryTreeNode {
        public int data;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }


}
