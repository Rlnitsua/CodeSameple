package rlnitsua.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rlnitsua.utils.node.TreeNode;
import rlnitsua.utils.node.TreeNodes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class KthSmallestElementinaBSTTest {
    private final TreeNode root;
    private final int k;
    private final int res;

    public KthSmallestElementinaBSTTest(TreeNode root, int k, int res) {
        this.root = root;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TreeNodes.create(Arrays.asList(3,1,4,null,2)), 1, 1},
                {TreeNodes.create(Arrays.asList(5,3,6,2,4,null,null,1)), 3, 3},
        });
    }

    @Test
    public void test() {
        KthSmallestElementinaBST demo = new KthSmallestElementinaBST();
        assertEquals(res, demo.kthSmallest(root, k));
    }
}