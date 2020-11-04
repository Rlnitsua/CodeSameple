package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;
import rlnitsua.utils.node.TreeNodes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumberofGoodLeafNodesPairsTest {
    private TreeNode root;
    private int distance;
    private int res;

    public NumberofGoodLeafNodesPairsTest(TreeNode root, int distance, int res) {
        this.root = root;
        this.distance = distance;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TreeNodes.create(Arrays.asList(1, 2, 3, null, 4)), 3, 1},
                {TreeNodes.create(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 3, 2},
                {TreeNodes.create(Arrays.asList(7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2)), 3, 1},
                {TreeNodes.create(Collections.singletonList(100)), 1, 0},
                {TreeNodes.create(Arrays.asList(1, 1, 1)), 2, 1},
        });
    }

    @Test
    public void test() {
        NumberofGoodLeafNodesPairs demo = new NumberofGoodLeafNodesPairs();
        assertEquals(res, demo.countPairs(root, distance));
    }
}