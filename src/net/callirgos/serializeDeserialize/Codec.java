package net.callirgos.serializeDeserialize;

import javax.xml.crypto.NodeSetData;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class Codec {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private void buildString(TreeNode root, StringBuilder sb)
    {
        if (root == null) {
            sb.append("n").append(",");
        } else {
            sb.append(root.val).append(",");
            buildString(root.left, sb);
            buildString(root.right,sb);
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private TreeNode buildTree(Queue<String> nodes)
    {

        String val = nodes.remove();
        if(val.equals("n")){
            return null;
        }
        else
        {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new ArrayDeque<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

}
