package net.callirgos.tree;

import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class tree {
    //BinaryTreeNode
    public static class BTreeNode {
        public int val;
        public BTreeNode left;
        public BTreeNode right;
        public BTreeNode( int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            // print level traversal
            Queue<BTreeNode> bfs = new LinkedList<>();
            HashMap<BTreeNode, Integer> levels = new HashMap<>();
            HashMap<Integer, List<BTreeNode>> levelOrder = new HashMap<>();
            bfs.add(this);
            levels.put(this, 1);
            while(!bfs.isEmpty()) {
                BTreeNode cur = bfs.remove();
                //level tracking
                int level = levels.get(cur);
                if( !levelOrder.containsKey(level)) {
                    levelOrder.put(level, new ArrayList<>());
                }
                levelOrder.get(level).add(cur);
                if(cur.left!=null){
                    bfs.add(cur.left);
                    levels.put(cur.left, level+1);
                }
                if(cur.right!=null) {
                    bfs.add(cur.right);
                    levels.put(cur.right, level+1);
                }
            }
            for( Integer level : levelOrder.keySet()) {
                for(BTreeNode toPrint : levelOrder.get(level)) {
                    sb.append(String.format("%d ",toPrint.val));
                }
                sb.append("\r\n");
            }
            return sb.toString();
        }
    }
    //nArrayTreeNode
    public static class TreeNode {
        public int val;
        public List<TreeNode> children;
        public TreeNode(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            // print level traversal
            Queue<TreeNode> bfs = new LinkedList<>();
            HashMap<TreeNode, Integer> levels = new HashMap<>();
            HashMap<Integer, List<TreeNode>> levelOrder = new HashMap<>();
            bfs.add(this);
            levels.put(this, 1);
            while(!bfs.isEmpty()) {
                TreeNode cur = bfs.remove();
                //level tracking
                int level = levels.get(cur);
                if( !levelOrder.containsKey(level)) {
                    levelOrder.put(level, new ArrayList<>());
                }
                levelOrder.get(level).add(cur);
                //children bfs printing
                for( TreeNode child : cur.children){
                    bfs.add(child);
                    levels.put(child, level+1);
                }
            }
            for( Integer level : levelOrder.keySet()) {
                for(TreeNode toPrint : levelOrder.get(level)) {
                    sb.append(String.format("%d ",toPrint.val));
                }
                sb.append("\r\n");
            }

            return sb.toString();
        }
    }

    private BTreeNode convertToBinary_rec( TreeNode root, boolean left ){
        if(root == null) {
            return null;
        }
        BTreeNode newTree = new BTreeNode(root.val);
        BTreeNode ptr = newTree;
        for( TreeNode child : root.children ) {
            if( left ) {
                newTree.left = convertToBinary_rec(child, !left);
                newTree = newTree.left;
            }
            else {
                newTree.right = convertToBinary_rec(child, !left);
                newTree = newTree.right;
            }
        }
        return ptr;
    }
    public BTreeNode convertToBinary( TreeNode root ) {
        return convertToBinary_rec(root, true);
    }

    private TreeNode convertToNarray_rec( BTreeNode root, boolean left) {
        if( root == null ) {
            return null;
        }
        TreeNode newTree = new TreeNode(root.val);
        BTreeNode ptr = root;
        if( left ) {
            while( ptr.left != null ) {
                TreeNode child = convertToNarray_rec( ptr.left, !left);
                newTree.children.add(child);
                ptr = ptr.left;
            }
        }
        else {
            while( ptr.right != null ) {
                TreeNode child = convertToNarray_rec( ptr.right, !left);
                newTree.children.add(child);
                ptr = ptr.right;
            }
        }
        return newTree;
    }
    public TreeNode convertToNarray( BTreeNode root ) {

        return convertToNarray_rec(root, true);
    }

}
