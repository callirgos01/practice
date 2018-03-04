package net.callirgos.mergeTrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTreesTest {

    @Test
    void mergeTrees() {
        MergeTrees mt = new MergeTrees();
        MergeTrees.TreeNode result = mt.mergeTrees(new MergeTrees.TreeNode(2), new MergeTrees.TreeNode(3));

        assertEquals(new MergeTrees.TreeNode(3).val,result.val);
    }
}