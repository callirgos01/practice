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
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        // Largest sum of them all.
        //

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int cur = 0;
            int pending = nums.length - i;
            for (int p = 0; p < pending; p++) {
                cur = cur + nums[p + i];
            }
            if (cur > max) {
                max = cur;
            }
        }

        System.out.println(max);

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
