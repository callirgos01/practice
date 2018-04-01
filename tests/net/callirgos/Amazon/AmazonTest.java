
package net.callirgos.Amazon;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AmazonTest {
    private void printTree(Amazon.OnSite.Codec.TreeNode root) {
        if(root==null)
            System.out.print("n ");
        else {
            System.out.printf("%d ",root.val);
            printTree(root.right);
            printTree(root.left);
        }
    }
    @Test
    public void encodeTreeTest(){
        Amazon.OnSite.Codec.TreeNode root = new Amazon.OnSite.Codec.TreeNode(1);
        root.right = new Amazon.OnSite.Codec.TreeNode(2);
        root.left = new Amazon.OnSite.Codec.TreeNode(3);
        root.right.right = new Amazon.OnSite.Codec.TreeNode(4);
        root.right.left = new Amazon.OnSite.Codec.TreeNode(5);
        root.left.right = new Amazon.OnSite.Codec.TreeNode(6);

        String result = new Amazon.OnSite.Codec().encodeTree(root);
        System.out.print("beforeTree[ ");
        printTree(root);
        System.out.println("] ");
        //System.out.println(result);

        Amazon.OnSite.Codec.TreeNode decodedTree = new Amazon.OnSite.Codec().decodeTree(result);
        System.out.print("afterTree [ ");
        printTree(decodedTree);
        System.out.println("] ");

    }

    @Test
    void subStringsKDist() {
        String input = "awaglknagawunagwkwagl";
        int input2 = 4;
        List<String> output =  new Amazon.PhoneScreen().subStringsKDist(input, input2);

        System.out.println(input);
        for(String cut : output) {
            System.out.println(cut);
        }

    }

    @Test
    void lengthEachScene() {
        String rawInput = "ababcbacadefegdehij";
        List<Character> input = new ArrayList<>();
        for(Character c: rawInput.toCharArray()) {
            input.add(c);
        }
        List<Integer> results = new Amazon.PhoneScreen().LengthEachScene(input);
        // not sure what the output should be
        for ( Integer result : results)
        {
            System.out.println(result);
        }
    }
}