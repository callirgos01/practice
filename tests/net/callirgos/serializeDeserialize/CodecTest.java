package net.callirgos.serializeDeserialize;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class CodecTest {

    @Test
    void serialize() {
        Codec.TreeNode root = new Codec.TreeNode(2);
        root.left = new Codec.TreeNode(1);
        root.right = new Codec.TreeNode(3);
        root.right.right = new Codec.TreeNode(4);
        String actualResult = new Codec().serialize(root);

        System.out.println(actualResult);
    }

    private void printRoot(Codec.TreeNode root)
    {
        if(root == null ) {
            System.out.println("empty tree");
        }
        else {
            Queue<Codec.TreeNode> nodes = new ArrayDeque<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                Codec.TreeNode node = nodes.remove();

                if (node.val == -1) {
                    System.out.println("null");
                    //toReturn.append("null,");
                } else {
                    System.out.printf("%d\r\n", node.val);
                    //toReturn.append(String.format("%d,", node.val));
                    if (node.left != null)
                        nodes.add(node.left);
                    else
                        nodes.add(new Codec.TreeNode(-1));
                    if (node.right != null)
                        nodes.add(node.right);
                    else
                        nodes.add(new Codec.TreeNode(-1));
                }
            }
        }
    }
    @Test
    void deserialize() {
        Codec.TreeNode startRoot = new Codec.TreeNode(2);
        startRoot.left = new Codec.TreeNode(1);
        startRoot.right = new Codec.TreeNode(3);

        Codec.TreeNode endRoot = new Codec().deserialize(new Codec().serialize(startRoot));
        printRoot(startRoot);
        printRoot(endRoot);

    }
}