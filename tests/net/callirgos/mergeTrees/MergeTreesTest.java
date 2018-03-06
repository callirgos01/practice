package net.callirgos.mergeTrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTreesTest {

    void assertEqualTrees(MergeTrees.TreeNode t1, MergeTrees.TreeNode t2)
    {
        if((t1 == null) && (t2 != null))
        {
            assertEquals(0,1);

        }
        if((t1 != null) && (t2 == null))
        {
            assertEquals(1,0);
        }

        if((t1 != null) && (t2 != null))
        {
            assertEquals(t1.val, t2.val);
            assertEqualTrees(t1.left, t2.left);
            assertEqualTrees(t1.right, t2.right);
        }
    }


    @Test
    void mergeTrees() {
        MergeTrees mt = new MergeTrees();
        MergeTrees.TreeNode t1 = new MergeTrees.TreeNode(1);
        t1.left = new MergeTrees.TreeNode(3);
        t1.right = new MergeTrees.TreeNode(2);
        t1.left.left = new MergeTrees.TreeNode(5);

        MergeTrees.TreeNode t2 = new MergeTrees.TreeNode(2);
        t2.left = new MergeTrees.TreeNode(1);
        t2.right = new MergeTrees.TreeNode(3);
        t2.left.right = new MergeTrees.TreeNode(4);
        t2.right.right = new MergeTrees.TreeNode(7);

        MergeTrees.TreeNode expectedResult = new MergeTrees.TreeNode(3);
        expectedResult.left = new MergeTrees.TreeNode(4);
        expectedResult.right = new MergeTrees.TreeNode(5);
        expectedResult.left.left = new MergeTrees.TreeNode(5);
        expectedResult.left.right = new MergeTrees.TreeNode(4);
        expectedResult.right.right = new MergeTrees.TreeNode(7);


        MergeTrees.TreeNode actualResult = mt.mergeTrees(t1, t2);

        assertEqualTrees(expectedResult, actualResult);
    }

}