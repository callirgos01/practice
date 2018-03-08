package net.callirgos.splitBST;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitBSTTest {

    void assertEqualTrees(SplitBST.TreeNode expected, SplitBST.TreeNode actual)
    {
        if((expected == null) && (actual != null))
        {
            assertEquals(expected,actual.val);

        }
        if((expected != null) && (actual == null))
        {
            assertEquals(expected.val,actual);
        }

        if((expected != null) && (actual != null))
        {
            assertEquals(expected.val, actual.val);
            assertEqualTrees(expected.left, actual.left);
            assertEqualTrees(expected.right, actual.right);
        }
    }
    @Test
    void splitBST() {
        int sampleV1 = 2;
        SplitBST.TreeNode sampleInput1 = new SplitBST.TreeNode(4);
        sampleInput1.left = new SplitBST.TreeNode(2);
        sampleInput1.right = new SplitBST.TreeNode(6);
        sampleInput1.left.left = new SplitBST.TreeNode(1);
        sampleInput1.left.right = new SplitBST.TreeNode(3);
        sampleInput1.right.left = new SplitBST.TreeNode(5);
        sampleInput1.right.right = new SplitBST.TreeNode(7);

        SplitBST.TreeNode[] expectedOutput = new SplitBST.TreeNode[]{new SplitBST.TreeNode(2),new SplitBST.TreeNode(4) };
        expectedOutput[1].left = new SplitBST.TreeNode(3);
        expectedOutput[1].right = new SplitBST.TreeNode(6);
        expectedOutput[1].right.left = new SplitBST.TreeNode(5);
        expectedOutput[1].right.right = new SplitBST.TreeNode(7);
        expectedOutput[0].left = new SplitBST.TreeNode(1);

        SplitBST.TreeNode[] actualOutput = new SplitBST().splitBST(sampleInput1, sampleV1);

        assertNotNull(actualOutput);
        assertEquals(expectedOutput.length, actualOutput.length);
        for(int i =0; i<expectedOutput.length; i++) {
            assertEqualTrees(expectedOutput[i], actualOutput[i]);
        }
    }
}