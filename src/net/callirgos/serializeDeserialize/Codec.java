package net.callirgos.serializeDeserialize;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class Codec {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder toReturn = new StringBuilder();

        if(root == null )
            return "n";

        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.remove();

            if(node.val == -1){
                System.out.println("n");
                toReturn.append("n,");
            }
            else {
                System.out.printf("%d\r\n",node.val);
                toReturn.append(String.format("%d,", node.val));
                if(node.left != null)
                    nodes.add(node.left);
                else
                    nodes.add(new TreeNode(-1));
                if(node.right != null)
                    nodes.add(node.right);
                else
                    nodes.add(new TreeNode(-1));
            }
        }

        return toReturn.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = new TreeNode(-1);
        TreeNode runningIterator = root;
        String[] splitData = data.split(",");
        int i = 0;

        Queue<String> nodes = new ArrayDeque<>();
        nodes.add("r"+splitData[i]);

        while(i<splitData.length)
        {
            String node = nodes.remove();
            if(!node.isEmpty()){
                if(node.equals("n")){
                    System.out.println("n");
                    //toReturn.append("n,");
                    i++;
                }
                else {
                    System.out.printf("%s\r\n",node);
                    runningIterator.val = Integer.valueOf(node);

                    runningIterator = runningIterator.left;
                    //add left
                    i++;
                    nodes.add(splitData[i]);
                    //add right
                    i++;
                    nodes.add(splitData[i]);
                    /*
                    toReturn.append(String.format("%d,", node.val));
                    if(node.left != null)
                        nodes.add(node.left);
                    else
                        nodes.add(new TreeNode(-1));
                    if(node.right != null)
                        nodes.add(node.right);
                    else
                        nodes.add(new TreeNode(-1));
                    */
                }
            }
        }
/*
        if(root == null )
            return "n";

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.remove();

        }*/

        return root;


    }

}
