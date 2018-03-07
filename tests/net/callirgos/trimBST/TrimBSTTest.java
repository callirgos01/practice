package net.callirgos.trimBST;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrimBSTTest {


    void assertEqualTrees(TrimBST.TreeNode expected, TrimBST.TreeNode actual)
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
    void trimBST() {
        int exampleL = 1;
        int exampleR = 2;
        TrimBST.TreeNode exampleInput = new TrimBST.TreeNode(1);
        exampleInput.left = new TrimBST.TreeNode(0);
        exampleInput.right = new TrimBST.TreeNode(2);

        TrimBST.TreeNode expectedOuput = new TrimBST.TreeNode(1);
        expectedOuput.right = new TrimBST.TreeNode(2);

        TrimBST.TreeNode actualOutput = new TrimBST().trimBST(exampleInput, exampleL, exampleR);

        assertEqualTrees( expectedOuput, actualOutput);
    }
}